package com.example.springboot.di.app.springboot_di.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.di.app.springboot_di.models.Product;
import com.example.springboot.di.app.springboot_di.services.ProductService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api")
public class ProductController {

    @GetMapping("")
    public List<Product> getAllProducts() {
        ProductService productService = new ProductService();

        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        ProductService productService = new ProductService();

        return productService.findById(id);
    }

}
