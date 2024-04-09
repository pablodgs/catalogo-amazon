package com.example.catalogo.domain.product;

import org.springframework.web.bind.annotation.RestController;

import com.example.catalogo.repositories.ProductRepository;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController()
public class ProductController {
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/products")
    public List<Product> all() {
        return productRepository.findAll();
    }

    @PostMapping("/product")
    public Product create(@RequestBody Product product) {
        System.out.println(product);
        return productRepository.save(product);
    }

}
