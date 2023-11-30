package io.github.jvictor12.AuthenticationAPIUsers.controller;

import io.github.jvictor12.AuthenticationAPIUsers.dto.ProductDTO;
import io.github.jvictor12.AuthenticationAPIUsers.entity.Product;
import io.github.jvictor12.AuthenticationAPIUsers.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(
                productService.findAll().stream().map(ProductDTO::new).toList());
    }

    @PostMapping
    public ResponseEntity save (@Valid @RequestBody Product product){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(product));
    }
}
