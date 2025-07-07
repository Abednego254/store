package com.abednego.shop.service;

import com.abednego.shop.model.OrderDetail;

import java.util.List;
import java.util.Optional;

public interface OrderDetailService {

    List<OrderDetail> getAll();

    Optional<OrderDetail> getById(Long id);

    List<OrderDetail> getByOrder(Long orderId);

    List<OrderDetail> getByProduct(Long productId);

    List<OrderDetail> getByLineNumber(int lineNumber);

    OrderDetail create(OrderDetail orderDetail);

    Optional<OrderDetail> update(Long id, OrderDetail updatedDetail);

    boolean delete(Long id);
}
