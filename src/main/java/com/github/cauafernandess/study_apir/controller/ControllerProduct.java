package com.github.cauafernandess.study_apir.controller;


import com.github.cauafernandess.study_apir.model.Product;
import com.github.cauafernandess.study_apir.service.ProductService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("product")
public class ControllerProduct {

    @Autowired
    private ProductService service;
   
    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product){
      
       Product productCreated  = service.createProduct(product);
        return ResponseEntity.status(201).body(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<Product>> update( @PathVariable  Long id, @RequestBody Product product){
       Optional<Product> productUpdated = service.updateProduct(id, product);
        return ResponseEntity.status(200).body(productUpdated);
    }

    @GetMapping
    public ResponseEntity<String> find(){
        service.getProductId(null);
        return ResponseEntity.status(200).body("zubumafu");
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(){
        service.deleteProduct(null);
        return ResponseEntity.status(204).build();
    }
}