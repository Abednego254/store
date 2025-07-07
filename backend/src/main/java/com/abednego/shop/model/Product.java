package com.abednego.shop.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @NotBlank(message = "Product code is required")
    @Size(max = 15, message = "Product code must not exceed 15 characters")
    @Column(name = "productCode", nullable = false, unique = true, length = 15)
    private String productCode;

    @NotBlank(message = "Product name is required")
    @Size(min = 2, max = 70, message = "Product name must be between 2 and 70 characters")
    @Column(name = "productName", nullable = false, length = 70)
    private String productName;

    @NotNull(message = "Product line is required")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "productLine", nullable = false)
    private ProductLine productLine;

    @NotBlank(message = "Product scale is required")
    @Size(max = 10, message = "Product scale must not exceed 10 characters")
    @Column(name = "productScale", nullable = false, length = 10)
    private String productScale;

    @NotBlank(message = "Product vendor is required")
    @Size(max = 50, message = "Product vendor must not exceed 50 characters")
    @Column(name = "productVendor", nullable = false, length = 50)
    private String productVendor;

    @NotBlank(message = "Product description is required")
    @Lob
    @Column(name = "productDescription", nullable = false)
    private String productDescription;

    @Min(value = 0, message = "Quantity in stock must be zero or more")
    @Column(name = "quantityInStock", nullable = false)
    private int quantityInStock;

    @NotNull(message = "Buy price is required")
    @Digits(integer = 8, fraction = 2, message = "Buy price must be a valid amount")
    @Positive(message = "Buy price must be positive")
    @Column(name = "buyPrice", nullable = false, precision = 10, scale = 2)
    private BigDecimal buyPrice;

    @NotNull(message = "MSRP is required")
    @Digits(integer = 8, fraction = 2, message = "MSRP must be a valid amount")
    @Positive(message = "MSRP must be positive")
    @Column(name = "MSRP", nullable = false, precision = 10, scale = 2)
    private BigDecimal MSRP;
}
