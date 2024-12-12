package com.example.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.springboot.di.app.springboot_di.models.Product;
import com.example.springboot.di.app.springboot_di.repositories.IProductRepository;



@Service
public class ProductService implements IProductService {


    private final IProductRepository productRepository;

    public ProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override   
    public List<Product> findAll() {
        return productRepository.findAll().stream().map(product -> {
            
            Double priceIva = product.getPrice() * 1.21d;
            Product newProduct = new Product(product.getId(), product.getName(), priceIva);

            return newProduct;

        }).collect(Collectors.toList());

    }


    @Override   
    public Product findById(Long id) {

        return productRepository.findById(id);

    }

}
