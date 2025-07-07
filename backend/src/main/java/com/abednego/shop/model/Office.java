package com.abednego.shop.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "offices")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Office {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @NotBlank(message = "Office code is required")
    @Size(max = 10, message = "Office code must not exceed 10 characters")
    @Column(name = "officeCode", nullable = false, unique = true, length = 10)
    private String officeCode;

    @NotBlank(message = "City is required")
    @Size(max = 50)
    @Column(name = "city", nullable = false, length = 50)
    private String city;

    @Size(max = 50)
    @Column(name = "phone", length = 50)
    @NotBlank(message = "Phone number is required")
    private String phone;

    @NotBlank(message = "Address Line 1 is required")
    @Size(max = 50)
    @Column(name = "addressLine1", nullable = false, length = 50)
    private String addressLine1;

    @Size(max = 50)
    @Column(name = "addressLine2", length = 50)
    private String addressLine2;

    @NotBlank(message = "State is required")
    @Size(max = 50)
    @Column(name = "state", nullable = false, length = 50)
    private String state;

    @NotBlank(message = "Country is required")
    @Size(max = 50)
    @Column(name = "country", nullable = false, length = 50)
    private String country;

    @NotBlank(message = "Postal code is required")
    @Size(max = 15)
    @Column(name = "postalCode", nullable = false, length = 15)
    private String postalCode;

    @NotBlank(message = "Territory is required")
    @Size(max = 10)
    @Column(name = "territory", nullable = false, length = 10)
    private String territory;
}
