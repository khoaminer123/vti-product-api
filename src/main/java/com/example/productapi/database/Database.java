package com.example.productapi.database;

import com.example.productapi.model.Product;
import com.example.productapi.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Database {
    @Bean
    CommandLineRunner initDatabase(ProductRepository productRepository) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Product product1 = new Product();
                product1.setId(1l);
                product1.setName("Ao");
                product1.setType("Phong");
                product1.setDesc("Ao phong Cotton");
                product1.setPrice(12000l);
                productRepository.save(product1);
            }
        };
    }
}
