package com.example.ProductService.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductDto {
    public UUID productId;
    public String title;
    public String description;
    public List<String> urls;
    public String brandName;
    public UUID subCategoryId;
}
