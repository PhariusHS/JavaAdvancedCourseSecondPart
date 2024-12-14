package com.example.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.example.springboot.di.app.springboot_di.models.Product;
import com.example.springboot.di.app.springboot_di.repositories.ProductRepository;

@Service
public class ProductService implements IProductService {

    @Autowired
    private Environment environment;

    private final ProductRepository productRepository;

    public ProductService( ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override   
    public List<Product> findAll() {
        return productRepository.findAll().stream().map(product -> {

            Double priceIva = product.getPrice() * environment.getProperty("config.iva", Double.class);

            Product newProduct = new Product(product.getId(), product.getName(), priceIva);

            return newProduct;

        }).collect(Collectors.toList());
    }

    @Override   
    public Product findById(Long id) {
        return productRepository.findById(id);
    }
}
