package com.abednego.shop.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @NotBlank(message = "Last name is required")
    @Size(max = 50)
    @Column(name = "lastName", nullable = false, length = 50)
    private String lastName;

    @NotBlank(message = "First name is required")
    @Size(max = 50)
    @Column(name = "firstName", nullable = false, length = 50)
    private String firstName;

    @NotBlank(message = "Extension is required")
    @Size(max = 10)
    @Column(name = "extension", nullable = false, length = 10)
    private String extension;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is required")
    @Size(max = 100)
    @Column(name = "email", nullable = false, length = 100, unique = true)
    private String email;

    @NotNull(message = "Office is required")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "officeCode", nullable = false)
    private Office office;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "reportsTo")
    private Employee manager;

    @NotBlank(message = "Job title is required")
    @Size(max = 50)
    @Column(name = "jobTitle", nullable = false, length = 50)
    private String jobTitle;
}
