package com.example.demo;

import java.awt.print.Pageable;

import org.hibernate.query.Page;

//package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    // Use Pageable for pagination
    Category findByCategoryName(String name);


}
