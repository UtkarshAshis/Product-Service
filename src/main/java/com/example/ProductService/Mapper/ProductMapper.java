package com.example.ProductService.Mapper;

import com.example.ProductService.Dto.ProductDto;
import com.example.ProductService.Entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toEntityWithoutSubCategory(ProductDto dto); // maps basic fields only
    ProductDto toDto(Product product);
}
