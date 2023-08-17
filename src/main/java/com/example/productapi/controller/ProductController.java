package com.example.productapi.controller;

import com.example.productapi.model.Product;
import com.example.productapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(productService.findAll());
    }

    @PostMapping("/insert")
    public Product insert(@RequestBody Product product)
    {
        return  productService.insert(product);
    }

    @PostMapping("/insertMulti")
    public List<Product> insertMulti(@RequestBody List<Product> productList)
    {
        return  productService.insertMulti(productList);
    }

    @PostMapping("/delete")
    public void delete(@RequestParam Long id){
        productService.delete(id);
    }

    @PostMapping("/update")
    public ResponseEntity<Product> update (@RequestBody Product product){
        return ResponseEntity.status(HttpStatus.OK).body(productService.update(product));
    }
}
