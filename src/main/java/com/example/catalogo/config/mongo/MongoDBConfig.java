package com.example.catalogo.config.mongo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

// import com.example.catalogo.domain.category.Category;
// import org.springframework.boot.CommandLineRunner;
// import com.example.catalogo.domain.product.Product;
// import com.example.catalogo.repositories.CategoryRepository;
// import com.example.catalogo.repositories.ProductRepository;

@Configuration
public class MongoDBConfig {
    @Bean
    public MongoDatabaseFactory mongoConfigure() {
        return new SimpleMongoClientDatabaseFactory("mongodb://localhost:27017/catalog-amazon");
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoConfigure());
    }

    // @Bean
    // CommandLineRunner commandLineRunner(CategoryRepository categoryRepository, ProductRepository productRepository) {
    //     return strings -> {
    //         System.out.println("MongoDB Configured");
    //         categoryRepository.save(new Category());
    //         productRepository.save(new Product("id19283", "title", "descript", "owndsers", 2138));
    //     };
    // }
}
