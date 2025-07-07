package com.abednego.shop.repository;

import com.abednego.shop.model.ProductLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductLineRepository extends JpaRepository<ProductLine, Long> {

    Optional<ProductLine> findByProductLine(String productLine);
}
