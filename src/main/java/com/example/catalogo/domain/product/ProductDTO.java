package com.example.catalogo.domain.product;

import com.example.catalogo.domain.category.Category;

public record ProductDTO(String title, String description, String ownerId, Integer price, String categoryId) {
}
