package com.abednego.shop.service.impl;

import com.abednego.shop.model.Employee;
import com.abednego.shop.repository.EmployeeRepository;
import com.abednego.shop.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAll() {
        log.info("Fetching all employees");
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getById(Long id) {
        log.info("Fetching employee by ID: {}", id);
        return employeeRepository.findById(id);
    }

    @Override
    public Optional<Employee> getByEmail(String email) {
        log.info("Fetching employee by email: {}", email);
        return employeeRepository.findByEmail(email);
    }

    @Override
    public List<Employee> getByOffice(Long officeId) {
        log.info("Fetching employees by office ID: {}", officeId);
        return employeeRepository.findByOffice_OfficeCode(String.valueOf(officeId));
    }

    @Override
    public List<Employee> getByManager(Long managerId) {
        log.info("Fetching employees who report to manager ID: {}", managerId);
        return employeeRepository.findByManager_Id(managerId);
    }

    @Override
    public Employee create(Employee employee) {
        log.info("Creating employee: {} {}", employee.getFirstName(), employee.getLastName());
        return employeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> update(Long id, Employee updatedEmployee) {
        log.info("Updating employee with ID: {}", id);
        return employeeRepository.findById(id).map(existing -> {
            updatedEmployee.setId(id);
            return employeeRepository.save(updatedEmployee);
        });
    }

    @Override
    public boolean delete(Long id) {
        log.info("Deleting employee with ID: {}", id);
        return employeeRepository.findById(id).map(existing -> {
            employeeRepository.deleteById(id);
            return true;
        }).orElse(false);
    }
}
