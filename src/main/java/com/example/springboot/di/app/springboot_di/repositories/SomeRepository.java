package com.example.springboot.di.app.springboot_di.repositories;

import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.example.springboot.di.app.springboot_di.models.Product;


@Repository
@Primary
public class SomeRepository implements IProductRepository {

    @Override
    public List<Product> findAll() {
      return Collections.singletonList(new Product(33l,"Product33",123.00d ));
    }

    @Override
    public Product findById(Long id) {
        return new Product(id,"Product33",123.00d );
    }
    
}
