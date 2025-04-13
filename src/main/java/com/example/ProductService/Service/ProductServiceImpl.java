package com.example.ProductService.Service;

import com.example.ProductService.Dto.ProductDto;
import com.example.ProductService.Entity.Product;
import com.example.ProductService.Entity.SubCategory;
import com.example.ProductService.GlobalException.ResourceNotFoundException;
import com.example.ProductService.Mapper.ProductMapper;
import com.example.ProductService.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductMapper productMapper;
    private final ProductRepository productRepository;
    private final SubCategoryService subCategoryService;

    @Autowired
    public ProductServiceImpl(ProductMapper productMapper, ProductRepository productRepository, SubCategoryService subCategoryService) {
        this.productMapper = productMapper;
        this.productRepository = productRepository;
        this.subCategoryService = subCategoryService;
    }

    @Override
    public Product createProduct(ProductDto productDto) {
        Product product = productMapper.toEntityWithoutSubCategory(productDto);
        SubCategory subCategory = subCategoryService.getSubCategory(productDto.getSubCategoryId());
        product.setSubCategory(subCategory);
        subCategory.getProductList().add(product);
        return productRepository.save(product);
    }

    @Override
    public Product getProduct(UUID id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No record found"));
    }

    @Override
    @Transactional
    public Product updateProduct(ProductDto productDto) {
        if(productDto.getProductId() != null){
            Product product = productRepository.findById(productDto.getProductId())
                    .orElseThrow(() -> new ResourceNotFoundException("No record found"));
            product.setUrls(productDto.getUrls());
            product.setTitle(productDto.getTitle());
            product.setDescription(productDto.getDescription());
            product.setBrandName(productDto.getBrandName());
            if(!product.getSubCategory().getId().equals(productDto.getSubCategoryId())){
                // here we need to change product category as well....
                product.getSubCategory().getProductList().remove(product);
                SubCategory subCategory = subCategoryService.getSubCategory(productDto.getSubCategoryId());
                product.setSubCategory(subCategory);
                subCategory.getProductList().add(product);
            }
            return productRepository.save(product);
        }else{
            throw new ResourceNotFoundException("No record found");
        }
    }

    @Override
    public boolean deleteProduct(UUID id) {
        try{
            productRepository.deleteById(id);
            return true;
        }catch (Exception exception){
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }
}
