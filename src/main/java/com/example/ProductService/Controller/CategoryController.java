package com.example.ProductService.Controller;

import com.example.ProductService.Dto.CategoryDto;
import com.example.ProductService.Entity.Category;
import com.example.ProductService.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    private final CategoryService categoryService;
    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createCategory(@RequestBody CategoryDto categoryDto){
        Category category = categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public ResponseEntity<?> getCategory(@RequestParam("categoryId") UUID categoryId){
        Category category = categoryService.getCategory(categoryId);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateCategory(@RequestBody CategoryDto categoryDto){
        Category category = categoryService.updateCategory(categoryDto);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteCategory(@RequestParam("categoryId") UUID categoryId){
        boolean b = categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>(b, HttpStatus.OK);
    }
    @GetMapping("/get/all")
    public ResponseEntity<?> getAllCategory(){
        List<Category> allCategory = categoryService.findAllCategory();
        return new ResponseEntity<>(allCategory, HttpStatus.OK);
    }
}
