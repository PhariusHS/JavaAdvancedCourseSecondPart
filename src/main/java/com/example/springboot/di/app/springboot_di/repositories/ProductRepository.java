package com.example.springboot.di.app.springboot_di.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.springboot.di.app.springboot_di.models.Product;


@Repository
public class ProductRepository implements IProductRepository {

   private List<Product> dataList;

    public ProductRepository() {
        this.dataList = Arrays.asList(
                new Product(1L, "someProduct", 300D),
                new Product(2L, "someProduct2", 400D),
                new Product(3l, "someProduct3", 500D));

    }

    @Override
    public List<Product> findAll(){
        return dataList;
    }

    @Override
    public Product findById(Long id){
        return dataList.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }


   
}
