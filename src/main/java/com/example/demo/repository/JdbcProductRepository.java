package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.Product;

@Repository
@Qualifier("jdbcRepo")
public class JdbcProductRepository implements ProductRepository {
    private final JdbcTemplate jdbcTemplate;

    public JdbcProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Product save(Product product) {
        String sql = "INSERT INTO product(name, price) VALUES(?, ?)";
        jdbcTemplate.update(sql, product.getName(), product.getPrice());
        return product;
    }

    @Override
    public void deleteById(Long id) {
        jdbcTemplate.update("DELETE FROM product WHERE id = ?", id);
    }

    @Override
    public Optional<Product> findById(Long id) {
        String sql = "SELECT id, name, price FROM product WHERE id = ?";
        try {
            Product product = jdbcTemplate.queryForObject(
                sql, 
                new BeanPropertyRowMapper<>(Product.class), 
                id
            );
            return Optional.of(product);
        } catch (org.springframework.dao.EmptyResultDataAccessException e) {
            // 조회된 결과가 없을 경우 빈 Optional 반환
            return Optional.empty();
        }
    }

    @Override
    public List<Product> findAll() {
        String sql = "SELECT id, name, price FROM product";
        return jdbcTemplate.query(
            sql, 
            new BeanPropertyRowMapper<>(Product.class)
        );
    }
}