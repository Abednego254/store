package com.abednego.shop.repository;

import com.abednego.shop.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByCustomerName(String customerName);

    List<Customer> findBySalesRep_Id(Long salesRepId);

    List<Customer> findByCountryIgnoreCase(String country);
}
