package com.abednego.shop.service;

import com.abednego.shop.model.Order;
import com.abednego.shop.model.OrderStatus;
import com.abednego.shop.dto.OrderRequest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface OrderService {

    List<Order> getAll();

    Optional<Order> getById(Long id);

    List<Order> getByCustomer(Long customerId);

    List<Order> getByStatus(OrderStatus status);

    List<Order> getBetweenDates(LocalDate startDate, LocalDate endDate);

    Order create(Order order);

    Optional<Order> update(Long id, Order updatedOrder);

    boolean delete(Long id);

    Order placeOrder(OrderRequest orderRequest);
}
