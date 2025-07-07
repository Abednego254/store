package com.abednego.shop.repository;

import com.abednego.shop.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {

    List<OrderDetail> findByOrder_Id(Long orderId);

    List<OrderDetail> findByProduct_Id(Long productId);

    List<OrderDetail> findByOrderLineNumber(int lineNumber);
}
