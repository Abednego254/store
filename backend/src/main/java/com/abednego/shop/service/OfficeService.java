package com.abednego.shop.service;

import com.abednego.shop.model.Office;

import java.util.List;
import java.util.Optional;

public interface OfficeService {

    List<Office> getAll();

    Optional<Office> getById(Long id);

    Optional<Office> getByOfficeCode(String officeCode);

    Office create(Office office);

    Optional<Office> update(Long id, Office updatedOffice);

    boolean delete(Long id);
}
