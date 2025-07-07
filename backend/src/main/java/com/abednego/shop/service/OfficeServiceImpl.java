package com.abednego.shop.service.impl;

import com.abednego.shop.model.Office;
import com.abednego.shop.repository.OfficeRepository;
import com.abednego.shop.service.OfficeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class OfficeServiceImpl implements OfficeService {

    private final OfficeRepository officeRepository;

    @Override
    public List<Office> getAll() {
        log.info("Fetching all offices");
        return officeRepository.findAll();
    }

    @Override
    public Optional<Office> getById(Long id) {
        log.info("Fetching office by ID: {}", id);
        return officeRepository.findById(id);
    }

    @Override
    public Optional<Office> getByOfficeCode(String officeCode) {
        log.info("Fetching office by code: {}", officeCode);
        return officeRepository.findByOfficeCode(officeCode);
    }

    @Override
    public Office create(Office office) {
        log.info("Creating office: {}", office.getOfficeCode());
        return officeRepository.save(office);
    }

    @Override
    public Optional<Office> update(Long id, Office updatedOffice) {
        log.info("Updating office with ID: {}", id);
        return officeRepository.findById(id).map(existing -> {
            updatedOffice.setId(id);
            return officeRepository.save(updatedOffice);
        });
    }

    @Override
    public boolean delete(Long id) {
        log.info("Deleting office with ID: {}", id);
        return officeRepository.findById(id).map(existing -> {
            officeRepository.deleteById(id);
            return true;
        }).orElse(false);
    }
}
