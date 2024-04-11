package com.example.catalogo.services;

import com.example.catalogo.domain.category.Category;
import com.example.catalogo.domain.category.CategoryDTO;
import com.example.catalogo.domain.category.exceptions.CategoryNotFoundException;
import com.example.catalogo.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private CategoryRepository repository;

    public CategoryService(CategoryRepository repository){
        this.repository = repository;
    }

    public Category insert(CategoryDTO categoryData){
        Category newCategory = new Category(categoryData);
        this.repository.save(newCategory);
        return newCategory;
    }

    public List<Category> getAll(){
        return this.repository.findAll();
    }

    public Optional<Category> getById(String id){
        return this.repository.findById(id);
    }

    public Category update(String id, CategoryDTO categoryData){
        Category updateCategory = this.repository.findById(id).orElseThrow(CategoryNotFoundException::new);

        if(!categoryData.title().isEmpty()) {
            updateCategory.setTitle(categoryData.title());
        }

        if(!categoryData.description().isEmpty()){
            updateCategory.setDescription(categoryData.description());
        }

        this.repository.save(updateCategory);

        return updateCategory;
    }

    public void delete(String id){
        Category deleteCategory = this.repository.findById(id).orElseThrow(CategoryNotFoundException::new);

        this.repository.delete(deleteCategory);
    }
}
