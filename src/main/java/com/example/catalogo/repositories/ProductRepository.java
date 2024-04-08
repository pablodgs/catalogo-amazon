package com.example.catalogo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.catalogo.domain.product.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String>{

}
