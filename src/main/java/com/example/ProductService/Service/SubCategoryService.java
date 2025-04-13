package com.example.ProductService.Service;

import com.example.ProductService.Dto.SubCategoryDto;
import com.example.ProductService.Entity.SubCategory;

import java.util.List;
import java.util.UUID;

public interface SubCategoryService {
    public SubCategory createSubCategory(SubCategoryDto subCategoryDto);
    public SubCategory updateSubCategory(SubCategoryDto subCategoryDto);
    public SubCategory getSubCategory(UUID id);
    public SubCategory saveSubCategory(SubCategory subCategory);
    public boolean deleteSubCategory(UUID id);
    public List<SubCategory> getAllSubCategory();
}
