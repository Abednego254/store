package com.abednego.shop.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.math.BigDecimal;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @NotBlank(message = "Order number is required")
    @Size(max = 50)
    @Column(name = "orderNumber", nullable = false, unique = true, length = 50)
    private String orderNumber;

    @NotNull(message = "Order date is required")
    @PastOrPresent(message = "Order date cannot be in the future")
    @Column(name = "orderDate", nullable = false)
    private LocalDate orderDate;

    @NotNull(message = "Required date is required")
    @FutureOrPresent(message = "Required date cannot be in the past")
    @Column(name = "requiredDate", nullable = false)
    private LocalDate requiredDate;

    @Column(name = "shippedDate")
    private LocalDate shippedDate;

    @Column(precision = 10, scale = 2)
    private BigDecimal totalAmount;

    @Size(max = 255)
    @Column(name = "comments", length = 255)
    private String comments;

    @NotNull(message = "Customer is required")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customerNumber", nullable = false)
    private Customer customer;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
