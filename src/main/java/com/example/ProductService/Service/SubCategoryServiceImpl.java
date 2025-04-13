package com.example.ProductService.Service;

import com.example.ProductService.Dto.SubCategoryDto;
import com.example.ProductService.Entity.Category;
import com.example.ProductService.Entity.SubCategory;
import com.example.ProductService.GlobalException.ResourceNotFoundException;
import com.example.ProductService.Mapper.SubCategoryMapper;
import com.example.ProductService.Repository.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SubCategoryServiceImpl implements SubCategoryService{
    private final CategoryService categoryService;
    private final SubCategoryRepository subCategoryRepository;
    private final SubCategoryMapper subCategoryMapper;

    @Autowired
    public SubCategoryServiceImpl(@Lazy CategoryService categoryService, SubCategoryRepository subCategoryRepository, SubCategoryMapper subCategoryMapper) {
        this.categoryService = categoryService;
        this.subCategoryRepository = subCategoryRepository;
        this.subCategoryMapper = subCategoryMapper;
    }


    @Override
    public SubCategory createSubCategory(SubCategoryDto subCategoryDto) {
        SubCategory subCategory = subCategoryMapper.toEntity(subCategoryDto);
        Category category = categoryService.getCategory(subCategoryDto.getCategoryId());
        category.getSubCategories().add(subCategory);
        subCategory.setCategory(category);
        return subCategoryRepository.save(subCategory);
    }

    @Override
    public SubCategory updateSubCategory(SubCategoryDto subCategoryDto) {
        SubCategory subCategory = getSubCategory(subCategoryDto.getId());
        subCategory.setName(subCategoryDto.getName());
        subCategory.setDescriptions(subCategoryDto.getDescriptions());
        if(subCategory.getCategory().getId().equals(subCategoryDto.getCategoryId())){
            Category category = categoryService.getCategory(subCategoryDto.getCategoryId());
            subCategory.setCategory(category);
        }
        return subCategoryRepository.save(subCategory);
    }

    @Override
    public SubCategory getSubCategory(UUID id) {
        return subCategoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No record found"));
    }

    @Override
    public SubCategory saveSubCategory(SubCategory subCategory) {
        return subCategoryRepository.save(subCategory);
    }

    @Override
    public boolean deleteSubCategory(UUID id) {
        try{
            subCategoryRepository.deleteById(id);
            return true;
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
        return false;
    }

    @Override
    public List<SubCategory> getAllSubCategory() {
        return subCategoryRepository.findAll();
    }
}
