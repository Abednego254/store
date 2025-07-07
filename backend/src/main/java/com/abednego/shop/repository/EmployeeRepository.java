package com.abednego.shop.repository;

import com.abednego.shop.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findByEmail(String email);

    List<Employee> findByOffice_OfficeCode(String officeCode);

    List<Employee> findByManager_Id(Long managerId);
}
