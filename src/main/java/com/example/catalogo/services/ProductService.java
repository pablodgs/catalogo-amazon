package com.example.catalogo.services;

import com.example.catalogo.domain.category.Category;
import com.example.catalogo.domain.category.exceptions.CategoryNotFoundException;
import com.example.catalogo.domain.product.Product;
import com.example.catalogo.domain.product.ProductDTO;
import com.example.catalogo.domain.product.exceptions.ProductNotFoundException;
import com.example.catalogo.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private CategoryService categoryService;
    private ProductRepository productRepository;

    public ProductService(CategoryService categoryService, ProductRepository productRepository){
        this.categoryService = categoryService;
        this.productRepository = productRepository;
    }

    public Product insert(ProductDTO productData){
        Category category = categoryService.getById(productData.categoryId()).orElseThrow(CategoryNotFoundException::new);
        Product newProduct = new Product(productData);
        newProduct.setCategory(category);
        this.productRepository.save(newProduct);
        return newProduct;
    }

    public List<Product> getAll(){
        return this.productRepository.findAll();
    }

    public Product update(String id, ProductDTO productData){
        Product updateProduct = this.productRepository.findById(id).orElseThrow(ProductNotFoundException::new);

        this.categoryService.getById(productData.categoryId()).ifPresent(updateProduct::setCategory);

        if(!productData.title().isEmpty()) {
            updateProduct.setTitle(productData.title());
        }

        if(!productData.description().isEmpty()){
            updateProduct.setDescription(productData.description());
        }

        if(productData.price() != null){
            updateProduct.setPrice(productData.price());
        }

        this.productRepository.save(updateProduct);

        return updateProduct;
    }

    public void delete(String id){
        Product deleteProduct = this.productRepository.findById(id).orElseThrow(ProductNotFoundException::new);

        this.productRepository.delete(deleteProduct);
    }
}
