package com.example.ProductService.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CategoryDto {
    public UUID id;
    public String name;
    public String descriptions;
    public UUID subCategoryId;
}
