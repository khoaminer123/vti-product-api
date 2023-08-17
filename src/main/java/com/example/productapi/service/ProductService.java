package com.example.productapi.service;

import com.example.productapi.model.Product;
import com.example.productapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Configuration
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    public Product insert (Product product){
        return productRepository.save(product);
    }

    public List<Product> insertMulti (List<Product> productList){
        return productRepository.saveAll(productList);
    }

    public void delete(Long id){
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()){
            productRepository.deleteById(id);
        }
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product update(Product product){
        Optional<Product> optionalProduct = productRepository.findById(product.getId());
        if (optionalProduct.isPresent()){
            Product p = optionalProduct.get();
            return productRepository.save(product);
        }
        return null;
    }
}
