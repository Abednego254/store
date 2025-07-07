package com.abednego.shop.controller;

import com.abednego.shop.model.Employee;
import com.abednego.shop.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
@Slf4j
@Validated
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> getAll() {
        log.info("GET /api/employees");
        return ResponseEntity.ok(employeeService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(@PathVariable Long id) {
        log.info("GET /api/employees/{}", id);
        return employeeService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Employee> getByEmail(@PathVariable String email) {
        log.info("GET /api/employees/email/{}", email);
        return employeeService.getByEmail(email)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/office/{officeId}")
    public ResponseEntity<List<Employee>> getByOffice(@PathVariable Long officeId) {
        log.info("GET /api/employees/office/{}", officeId);
        return ResponseEntity.ok(employeeService.getByOffice(officeId));
    }

    @GetMapping("/manager/{managerId}")
    public ResponseEntity<List<Employee>> getByManager(@PathVariable Long managerId) {
        log.info("GET /api/employees/manager/{}", managerId);
        return ResponseEntity.ok(employeeService.getByManager(managerId));
    }

    @PostMapping
    public ResponseEntity<Employee> create(@Valid @RequestBody Employee employee) {
        log.info("POST /api/employees");
        return ResponseEntity.ok(employeeService.create(employee));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> update(@PathVariable Long id, @Valid @RequestBody Employee employee) {
        log.info("PUT /api/employees/{}", id);
        return employeeService.update(id, employee)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        log.info("DELETE /api/employees/{}", id);
        return employeeService.delete(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
