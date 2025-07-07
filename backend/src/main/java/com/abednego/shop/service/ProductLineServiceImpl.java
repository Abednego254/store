package com.abednego.shop.service;

import com.abednego.shop.model.ProductLine;
import com.abednego.shop.repository.ProductLineRepository;
import com.abednego.shop.service.ProductLineService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductLineServiceImpl implements ProductLineService {

    private final ProductLineRepository productLineRepository;

    @Override
    public List<ProductLine> getAll() {
        log.info("Fetching all product lines");
        return productLineRepository.findAll();
    }
}
