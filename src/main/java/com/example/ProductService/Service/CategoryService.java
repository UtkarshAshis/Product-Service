package com.example.ProductService.Service;

import com.example.ProductService.Dto.CategoryDto;
import com.example.ProductService.Entity.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    public Category createCategory(CategoryDto categoryDto);
    public Category getCategory(UUID id);
    public Category updateCategory(CategoryDto categoryDto);
    public boolean deleteCategory(UUID id);
    public boolean removeSubCategory(CategoryDto categoryDto);
    public List<Category> findAllCategory();
}
