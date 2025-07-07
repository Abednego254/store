package com.abednego.shop.service;

import com.abednego.shop.model.Payment;

import java.util.List;
import java.util.Optional;

public interface PaymentService {

    List<Payment> getAll();

    Optional<Payment> getById(Long id);

    List<Payment> getByCustomer(Long customerId);

    List<Payment> searchByCheckNumber(String partialCheckNumber);

    Payment create(Payment payment);

    Optional<Payment> update(Long id, Payment updatedPayment);

    boolean delete(Long id);
}
