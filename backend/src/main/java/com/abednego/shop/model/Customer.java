package com.abednego.shop.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @NotBlank(message = "Customer name is required")
    @Size(max = 50)
    @Column(name = "customerName", nullable = false, length = 50)
    private String customerName;

    @NotBlank(message = "Contact last name is required")
    @Size(max = 50)
    @Column(name = "contactLastName", nullable = false, length = 50)
    private String contactLastName;

    @NotBlank(message = "Contact first name is required")
    @Size(max = 50)
    @Column(name = "contactFirstName", nullable = false, length = 50)
    private String contactFirstName;

    @NotBlank(message = "Phone is required")
    @Size(max = 50)
    @Column(name = "phone", nullable = false, length = 50)
    private String phone;

    @NotBlank(message = "Address Line 1 is required")
    @Size(max = 50)
    @Column(name = "addressLine1", nullable = false, length = 50)
    private String addressLine1;

    @Size(max = 50)
    @Column(name = "addressLine2", length = 50)
    private String addressLine2;

    @NotBlank(message = "City is required")
    @Size(max = 50)
    @Column(name = "city", nullable = false, length = 50)
    private String city;

    @Size(max = 50)
    @Column(name = "state", length = 50)
    private String state;

    @NotBlank(message = "Postal code is required")
    @Size(max = 15)
    @Column(name = "postalCode", nullable = false, length = 15)
    private String postalCode;

    @NotBlank(message = "Country is required")
    @Size(max = 50)
    @Column(name = "country", nullable = false, length = 50)
    private String country;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "salesRepEmployeeNumber")
    private Employee salesRep;

    @NotNull(message = "Credit limit is required")
    @Digits(integer = 10, fraction = 2, message = "Credit limit must be a valid amount")
    @PositiveOrZero(message = "Credit limit cannot be negative")
    @Column(name = "creditLimit", nullable = false, precision = 10, scale = 2)
    private java.math.BigDecimal creditLimit;
}
