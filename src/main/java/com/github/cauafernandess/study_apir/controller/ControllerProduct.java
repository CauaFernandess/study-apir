package com.github.cauafernandess.study_apir.controller;


import com.github.cauafernandess.study_apir.model.Product;
import com.github.cauafernandess.study_apir.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("product")
public class ControllerProduct {

    @Autowired
    private ProductService service;
   
    @PostMapping
    public ResponseEntity<String> create(Product product){
        System.out.println(product.getNome());
        service.createProduct(null);
        return ResponseEntity.status(201).body("Produto cadastrado");
    }

    @PutMapping
    public ResponseEntity<String> update(){
        service.updateProduct(null, null);
        return ResponseEntity.status(200).body("produto atualizado");
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