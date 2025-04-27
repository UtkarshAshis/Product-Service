package com.example.ProductService.Controller;

import com.example.ProductService.Dto.ProductDto;
import com.example.ProductService.Dto.ProductImageDto;
import com.example.ProductService.Entity.Product;
import com.example.ProductService.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    private final ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @PostMapping("/create")
    public ResponseEntity<?> createProduct(@RequestBody ProductDto productDto){
        Product product = productService.createProduct(productDto);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }
    @PostMapping("/create-product")
    public ResponseEntity<?> createProductMultipart(@RequestBody ProductImageDto productDto){
        // here we need to upload all image to AWS s3 bucket...
        // then we will save productDto...
        return null;
    }
    @GetMapping("/get")
    public ResponseEntity<?> getProduct(@RequestParam("productId") UUID productId){
        Product product = productService.getProduct(productId);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<?> updateProduct(@RequestBody ProductDto productDto){
        Product product = productService.updateProduct(productDto);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteProduct(@RequestParam("productId") UUID productId){
        boolean b = productService.deleteProduct(productId);
        return new ResponseEntity<>(b, HttpStatus.OK);
    }
    @GetMapping("/get/all")
    public ResponseEntity<?> getAllProduct(){
        List<Product> productList = productService.getAllProduct();
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }
}
