package com.abednego.shop.controller;

import com.abednego.shop.model.Customer;
import com.abednego.shop.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
@Slf4j
@Validated
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> getAll() {
        log.info("GET /api/customers");
        return ResponseEntity.ok(customerService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getById(@PathVariable Long id) {
        log.info("GET /api/customers/{}", id);
        return customerService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Customer> getByName(@PathVariable String name) {
        log.info("GET /api/customers/name/{}", name);
        return customerService.getByCustomerName(name)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/rep/{employeeId}")
    public ResponseEntity<List<Customer>> getBySalesRep(@PathVariable Long employeeId) {
        log.info("GET /api/customers/rep/{}", employeeId);
        return ResponseEntity.ok(customerService.getBySalesRep(employeeId));
    }

    @GetMapping("/country/{country}")
    public ResponseEntity<List<Customer>> getByCountry(@PathVariable String country) {
        log.info("GET /api/customers/country/{}", country);
        return ResponseEntity.ok(customerService.getByCountry(country));
    }

    @PostMapping
    public ResponseEntity<Customer> create(@Valid @RequestBody Customer customer) {
        log.info("POST /api/customers");
        return ResponseEntity.ok(customerService.create(customer));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> update(@PathVariable Long id, @Valid @RequestBody Customer customer) {
        log.info("PUT /api/customers/{}", id);
        return customerService.update(id, customer)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        log.info("DELETE /api/customers/{}", id);
        return customerService.delete(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
