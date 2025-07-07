package com.abednego.shop.controller;

import com.abednego.shop.model.OrderDetail;
import com.abednego.shop.service.OrderDetailService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order-details")
@RequiredArgsConstructor
@Slf4j
@Validated
public class OrderDetailController {

    private final OrderDetailService orderDetailService;

    @GetMapping
    public ResponseEntity<List<OrderDetail>> getAll() {
        log.info("GET /api/order-details");
        return ResponseEntity.ok(orderDetailService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDetail> getById(@PathVariable Long id) {
        log.info("GET /api/order-details/{}", id);
        return orderDetailService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<List<OrderDetail>> getByOrder(@PathVariable Long orderId) {
        log.info("GET /api/order-details/order/{}", orderId);
        return ResponseEntity.ok(orderDetailService.getByOrder(orderId));
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<OrderDetail>> getByProduct(@PathVariable Long productId) {
        log.info("GET /api/order-details/product/{}", productId);
        return ResponseEntity.ok(orderDetailService.getByProduct(productId));
    }

    @GetMapping("/line/{lineNumber}")
    public ResponseEntity<List<OrderDetail>> getByLine(@PathVariable int lineNumber) {
        log.info("GET /api/order-details/line/{}", lineNumber);
        return ResponseEntity.ok(orderDetailService.getByLineNumber(lineNumber));
    }

    @PostMapping
    public ResponseEntity<OrderDetail> create(@Valid @RequestBody OrderDetail orderDetail) {
        log.info("POST /api/order-details");
        return ResponseEntity.ok(orderDetailService.create(orderDetail));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDetail> update(@PathVariable Long id, @Valid @RequestBody OrderDetail orderDetail) {
        log.info("PUT /api/order-details/{}", id);
        return orderDetailService.update(id, orderDetail)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        log.info("DELETE /api/order-details/{}", id);
        return orderDetailService.delete(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
