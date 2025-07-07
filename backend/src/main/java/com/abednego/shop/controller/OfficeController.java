package com.abednego.shop.controller;

import com.abednego.shop.model.Office;
import com.abednego.shop.service.OfficeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/offices")
@RequiredArgsConstructor
@Slf4j
@Validated
public class OfficeController {

    private final OfficeService officeService;

    @GetMapping
    public ResponseEntity<List<Office>> getAll() {
        log.info("GET /api/offices");
        return ResponseEntity.ok(officeService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Office> getById(@PathVariable Long id) {
        log.info("GET /api/offices/{}", id);
        return officeService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/code/{officeCode}")
    public ResponseEntity<Office> getByOfficeCode(@PathVariable String officeCode) {
        log.info("GET /api/offices/code/{}", officeCode);
        return officeService.getByOfficeCode(officeCode)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Office> create(@Valid @RequestBody Office office) {
        log.info("POST /api/offices");
        return ResponseEntity.ok(officeService.create(office));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Office> update(@PathVariable Long id, @Valid @RequestBody Office office) {
        log.info("PUT /api/offices/{}", id);
        return officeService.update(id, office)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        log.info("DELETE /api/offices/{}", id);
        return officeService.delete(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
