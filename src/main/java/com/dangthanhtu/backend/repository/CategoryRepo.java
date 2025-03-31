package com.dangthanhtu.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dangthanhtu.backend.entity.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {
    Category findByCategoryName(String categoryName);
}