package com.example.demo;
import org.springframework.stereotype.Component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Component;
@ComponentScan(basePackages = "com.example.demo")

@SpringBootApplication
public class NimapApplication {

	public static void main(String[] args) {
		SpringApplication.run(NimapApplication.class, args);
	}

}

class DataInitializer implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    @Autowired
    public DataInitializer(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) {
        // Create categories
        Category electronicsCategory = new Category("Electronics");
        Category clothingCategory = new Category("Clothing");

        // Save categories to the database
        categoryRepository.save(electronicsCategory);
        categoryRepository.save(clothingCategory);

        // Create and save products associated with categories
        Product smartphone = new Product("Smartphone", 500.0);
        Product laptop = new Product("Laptop", 1000.0);
        Product tShirt = new Product("T-shirt", 20.0);

        electronicsCategory.addProduct(smartphone);
        electronicsCategory.addProduct(laptop);
        clothingCategory.addProduct(tShirt);

        productRepository.save(smartphone);
        productRepository.save(laptop);
        productRepository.save(tShirt);
    }
}
