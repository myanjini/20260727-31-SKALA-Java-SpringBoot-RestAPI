package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import com.example.demo.dto.Product;

public interface ProductRepository {
    Product save(Product product);
    Optional<Product> findById(Long id);
    List<Product> findAll();
    void deleteById(Long id);
}
