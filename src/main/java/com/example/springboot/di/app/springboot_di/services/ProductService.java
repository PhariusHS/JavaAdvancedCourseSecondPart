package com.example.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import com.example.springboot.di.app.springboot_di.models.Product;
import com.example.springboot.di.app.springboot_di.repositories.ProductRepository;

public class ProductService {

    private ProductRepository productRepository = new ProductRepository();

    public List<Product> findAll() {
        return productRepository.findAll().stream().map(product -> {
            
            Double priceIva = product.getPrice() * 1.21d;
            Product newProduct = new Product(product.getId(), product.getName(), priceIva);

            return newProduct;

        }).collect(Collectors.toList());

    }

    public Product findById(Long id) {

        return productRepository.findById(id);

    }

}
