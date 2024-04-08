package com.example.catalogo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.catalogo.domain.category.Category;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {
    
}
