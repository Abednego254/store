package com.abednego.shop.service.impl;

import com.abednego.shop.dto.OrderRequest;
import com.abednego.shop.model.OrderStatus;
import com.abednego.shop.model.*;
import com.abednego.shop.repository.*;
import com.abednego.shop.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    private final OrderDetailRepository orderDetailRepository;

    @Override
    public List<Order> getAll() {
        log.info("Fetching all orders");
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> getById(Long id) {
        log.info("Fetching order by ID: {}", id);
        return orderRepository.findById(id);
    }

    @Override
    public List<Order> getByCustomer(Long customerId) {
        log.info("Fetching orders for customer ID: {}", customerId);
        return orderRepository.findByCustomer_Id(customerId);
    }

    @Override
    public List<Order> getByStatus(OrderStatus status) {
        log.info("Fetching orders by status: {}", status);
        return orderRepository.findByStatus(status);
    }

    @Override
    public List<Order> getBetweenDates(LocalDate startDate, LocalDate endDate) {
        log.info("Fetching orders between {} and {}", startDate, endDate);
        return orderRepository.findByOrderDateBetween(startDate, endDate);
    }

    @Override
    public Order create(Order order) {
        log.info("Creating order for customer ID: {}", order.getCustomer().getId());
        return orderRepository.save(order);
    }

    @Override
    public Optional<Order> update(Long id, Order updatedOrder) {
        log.info("Updating order with ID: {}", id);
        return orderRepository.findById(id).map(existing -> {
            updatedOrder.setId(id);
            return orderRepository.save(updatedOrder);
        });
    }

    @Override
    public boolean delete(Long id) {
        log.info("Deleting order with ID: {}", id);
        return orderRepository.findById(id).map(existing -> {
            orderRepository.deleteById(id);
            return true;
        }).orElse(false);
    }

    @Override
@Transactional
public Order placeOrder(OrderRequest request) {
    log.info("Placing new order for customer ID: {}", request.getCustomerId());

    // Fetch customer
    Customer customer = customerRepository.findById(request.getCustomerId())
        .orElseThrow(() -> {
            log.error("Customer not found: ID {}", request.getCustomerId());
            return new RuntimeException("Customer not found");
        });

    // Create new order
    Order order = new Order();
    order.setCustomer(customer);
    order.setOrderDate(LocalDate.now());
    order.setRequiredDate(LocalDate.now().plusDays(5));
    order.setStatus(OrderStatus.PENDING);
    order.setOrderNumber("ORD-" + UUID.randomUUID());

    log.info("Initialized order object: {}", order);

    BigDecimal totalPrice = BigDecimal.ZERO;

    // Save order to get ID
    order = orderRepository.save(order);
    log.info("Saved new order with ID: {}", order.getId());

    // Process each product
    for (OrderRequest.OrderProductDTO dto : request.getProducts()) {
        log.info("Processing product ID: {}, quantity: {}", dto.getProductId(), dto.getQuantity());

        Product product = productRepository.findById(dto.getProductId())
            .orElseThrow(() -> {
                log.error("Product not found: ID {}", dto.getProductId());
                return new RuntimeException("Product not found");
            });

        if (product.getQuantityInStock() < dto.getQuantity()) {
            log.error("Insufficient stock for product '{}'. In stock: {}, requested: {}",
                product.getProductName(), product.getQuantityInStock(), dto.getQuantity());
            throw new RuntimeException("Insufficient stock for product: " + product.getProductName());
        }

        BigDecimal priceEach = product.getBuyPrice();
        int quantity = dto.getQuantity();
        BigDecimal lineTotal = priceEach.multiply(BigDecimal.valueOf(quantity));
        totalPrice = totalPrice.add(lineTotal);

        OrderDetail detail = new OrderDetail();
        detail.setOrder(order);
        detail.setProduct(product);
        detail.setQuantityOrdered(quantity);
        detail.setPriceEach(priceEach);
        detail.setOrderLineNumber(UUID.randomUUID().hashCode());

        log.info("Saving order detail: {}", detail);
        orderDetailRepository.save(detail);

        product.setQuantityInStock(product.getQuantityInStock() - quantity);
        log.info("Updating product stock for '{}'. New stock: {}", product.getProductName(), product.getQuantityInStock());
        productRepository.save(product);
    }

    try {
        order.setTotalAmount(totalPrice);
        log.info("Final total amount: {}", totalPrice);

        order = orderRepository.save(order);
        log.info("Final order saved successfully with ID: {}", order.getId());

        return order;
    } catch (Exception e) {
        log.error("Error saving final order: {}", e.getMessage(), e);
        throw e;
    }
}

}
