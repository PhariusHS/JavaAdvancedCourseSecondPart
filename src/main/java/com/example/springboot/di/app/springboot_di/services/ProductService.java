package com.example.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.example.springboot.di.app.springboot_di.models.Product;
import com.example.springboot.di.app.springboot_di.repositories.ProductRepository;



@Service
public class ProductService implements IProductService {

    private final Environment environment;
    private final ProductRepository productRepository;

    public ProductService(@Qualifier("productRepository") ProductRepository productRepository, Environment environment) {
        this.productRepository = productRepository;
        this.environment = environment;
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
