package com.abednego.shop.controller;

import com.abednego.shop.model.ProductLine;
import com.abednego.shop.service.ProductLineService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product-lines")
@RequiredArgsConstructor
@Slf4j
@Validated
public class ProductLineController {

    private final ProductLineService productLineService;

    @GetMapping
    public ResponseEntity<List<ProductLine>> getAll() {
        log.info("GET /api/product-lines");
        return ResponseEntity.ok(productLineService.getAll());
    }
}