package com.abednego.shop.service.impl;

import com.abednego.shop.model.OrderDetail;
import com.abednego.shop.repository.OrderDetailRepository;
import com.abednego.shop.service.OrderDetailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderDetailServiceImpl implements OrderDetailService {

    private final OrderDetailRepository orderDetailRepository;

    @Override
    public List<OrderDetail> getAll() {
        log.info("Fetching all order details");
        return orderDetailRepository.findAll();
    }

    @Override
    public Optional<OrderDetail> getById(Long id) {
        log.info("Fetching order detail by ID: {}", id);
        return orderDetailRepository.findById(id);
    }

    @Override
    public List<OrderDetail> getByOrder(Long orderId) {
        log.info("Fetching order details for order ID: {}", orderId);
        return orderDetailRepository.findByOrder_Id(orderId);
    }

    @Override
    public List<OrderDetail> getByProduct(Long productId) {
        log.info("Fetching order details for product ID: {}", productId);
        return orderDetailRepository.findByProduct_Id(productId);
    }

    @Override
    public List<OrderDetail> getByLineNumber(int lineNumber) {
        log.info("Fetching order details by line number: {}", lineNumber);
        return orderDetailRepository.findByOrderLineNumber(lineNumber);
    }

    @Override
    public OrderDetail create(OrderDetail orderDetail) {
        log.info("Creating order detail for order ID: {}", orderDetail.getOrder().getId());
        return orderDetailRepository.save(orderDetail);
    }

    @Override
    public Optional<OrderDetail> update(Long id, OrderDetail updatedDetail) {
        log.info("Updating order detail with ID: {}", id);
        return orderDetailRepository.findById(id).map(existing -> {
            updatedDetail.setId(id);
            return orderDetailRepository.save(updatedDetail);
        });
    }

    @Override
    public boolean delete(Long id) {
        log.info("Deleting order detail with ID: {}", id);
        return orderDetailRepository.findById(id).map(existing -> {
            orderDetailRepository.deleteById(id);
            return true;
        }).orElse(false);
    }
}
