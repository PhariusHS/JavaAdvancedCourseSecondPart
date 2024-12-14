package com.example.springboot.di.app.springboot_di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import com.example.springboot.di.app.springboot_di.repositories.ProductRepository;

@Configuration
@PropertySource("classpath:configuration.properties")
public class AppConfig {
    

    @Bean
    @Primary
     ProductRepository productRepositoryJson(){
        return new ProductRepository();
    }


}
