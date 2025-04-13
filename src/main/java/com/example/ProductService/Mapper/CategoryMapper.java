package com.example.ProductService.Mapper;

import com.example.ProductService.Dto.CategoryDto;
import com.example.ProductService.Dto.ProductDto;
import com.example.ProductService.Entity.Category;
import com.example.ProductService.Entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    public Category toEntity(CategoryDto categoryDto);
    public CategoryDto toDto(Category category);
}
