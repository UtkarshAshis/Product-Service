package com.example.ProductService.Service;

import com.example.ProductService.Dto.ProductDto;
import com.example.ProductService.Entity.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    public Product createProduct(ProductDto productDto);
    public Product getProduct(UUID id);
    public Product updateProduct(ProductDto productDto);
    public boolean deleteProduct(UUID id);
    public List<Product> getAllProduct();
}
