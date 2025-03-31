package com.dangthanhtu.backend.service;

import com.dangthanhtu.backend.entity.Category;
import com.dangthanhtu.backend.payloads.CategoryDTO;
import com.dangthanhtu.backend.payloads.CategoryResponse;

public interface CategoryService {

    CategoryDTO createCategory(Category category);

    CategoryResponse getCategories(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);

    CategoryDTO getCategoryById(Long categoryId);

    CategoryDTO updateCategory(Category category, Long categoryId);

    String deleteCategory(Long categoryId);
}