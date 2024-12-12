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

    
    private final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    public List<Product> getAllProducts() {

        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {

        return productService.findById(id);
    }

}
