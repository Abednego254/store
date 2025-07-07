package com.abednego.shop.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "orderdetails")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @NotNull(message = "Order is required")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @NotNull(message = "Product is required")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Positive(message = "Quantity ordered must be greater than 0")
    @Column(name = "quantity_ordered", nullable = false)
    private int quantityOrdered;

    @NotNull(message = "Price each is required")
    @Digits(integer = 10, fraction = 2, message = "Price must be a valid amount")
    @Positive(message = "Price each must be positive")
    @Column(name = "price_each", nullable = false, precision = 10, scale = 2)
    private BigDecimal priceEach;

    @Positive(message = "Line number must be positive")
    @Column(name = "order_line_number", nullable = false)
    private int orderLineNumber;
}
