package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Product;
import com.example.demo.service.ProductService;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    // 상품 목록 조회
    @GetMapping("/product")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // 상품 등록 후 상품 목록을 반환
    @PostMapping("/product")
    public List<Product> insert(@RequestBody Product product) {
        productService.addProduct(product);
        return productService.getAllProducts();
    }

    // 상품 삭제
    @DeleteMapping("/product/{id}")
    public String delete(@PathVariable("id") long id) {
        productService.deleteProduct(id);
        return HttpStatus.OK.toString();
    }
}
