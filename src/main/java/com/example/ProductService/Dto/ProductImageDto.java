package com.example.ProductService.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductImageDto {
    public UUID productId;
    public String title;
    public String description;
    public List<MultipartFile> images;
    public String brandName;
    public UUID subCategoryId;
}
