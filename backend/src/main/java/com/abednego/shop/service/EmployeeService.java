package com.abednego.shop.service;

import com.abednego.shop.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<Employee> getAll();

    Optional<Employee> getById(Long id);

    Optional<Employee> getByEmail(String email);

    List<Employee> getByOffice(Long officeId);

    List<Employee> getByManager(Long managerId);

    Employee create(Employee employee);

    Optional<Employee> update(Long id, Employee updatedEmployee);

    boolean delete(Long id);
}
