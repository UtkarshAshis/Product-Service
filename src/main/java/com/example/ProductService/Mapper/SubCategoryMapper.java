package com.example.ProductService.Mapper;

import com.example.ProductService.Dto.ProductDto;
import com.example.ProductService.Dto.SubCategoryDto;
import com.example.ProductService.Entity.Product;
import com.example.ProductService.Entity.SubCategory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubCategoryMapper {
    public SubCategory toEntity(SubCategoryDto subCategoryDto);
    public SubCategoryDto toDto(SubCategory subCategory);
}
