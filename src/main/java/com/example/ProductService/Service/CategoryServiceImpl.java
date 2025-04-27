package com.example.ProductService.Service;

import com.example.ProductService.Dto.CategoryDto;
import com.example.ProductService.Entity.Category;
import com.example.ProductService.Entity.SubCategory;
import com.example.ProductService.GlobalException.ResourceNotFoundException;
import com.example.ProductService.Mapper.CategoryMapper;
import com.example.ProductService.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    private final SubCategoryService subCategoryService;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper, SubCategoryService subCategoryService) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
        this.subCategoryService = subCategoryService;
    }
    @PreAuthorize("hasAuthority('ROLE_USER')")
    @Override
    public Category createCategory(CategoryDto categoryDto) {
        Category category = categoryMapper.toEntity(categoryDto);
        return categoryRepository.save(category);
    }

    @Override
    public Category getCategory(UUID id) {
        return categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No record found"));
    }

    @Override
    public Category updateCategory(CategoryDto categoryDto) {
        Category category = getCategory(categoryDto.getId());
        category.setName(categoryDto.getName());
        category.setDescriptions(categoryDto.getDescriptions());
        return categoryRepository.save(category);
    }
    @Override
    public boolean removeSubCategory(CategoryDto categoryDto){
        Category category = getCategory(categoryDto.getId());
        SubCategory subCategory = subCategoryService.getSubCategory(categoryDto.getSubCategoryId());
        category.getSubCategories().remove(subCategory);
        categoryRepository.save(category);
        return true;
    }

    @Override
    public List<Category> findAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public boolean deleteCategory(UUID id) {
        categoryRepository.deleteById(id);
        return true;
    }
}
