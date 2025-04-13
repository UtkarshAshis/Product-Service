package com.example.ProductService.Controller;

import com.example.ProductService.Dto.SubCategoryDto;
import com.example.ProductService.Entity.SubCategory;
import com.example.ProductService.Service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/sub-category")
public class SubCategoryController {
    private final SubCategoryService subCategoryService;
    @Autowired
    public SubCategoryController(SubCategoryService subCategoryService) {
        this.subCategoryService = subCategoryService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createSubCategory(@RequestBody SubCategoryDto subCategoryDto){
        SubCategory subCategory = subCategoryService.createSubCategory(subCategoryDto);
        return new ResponseEntity<>(subCategory, HttpStatus.CREATED);
    }
    @GetMapping("/get")
    public ResponseEntity<?> getSubCategory(@RequestParam UUID subCategoryId){
        SubCategory subCategory = subCategoryService.getSubCategory(subCategoryId);
        return new ResponseEntity<>(subCategory, HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<?> updateSubCategory(@RequestBody SubCategoryDto subCategoryDto){
        SubCategory subCategory = subCategoryService.updateSubCategory(subCategoryDto);
        return new ResponseEntity<>(subCategory, HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteSubCategory(@RequestParam UUID subCategoryId){
        boolean b = subCategoryService.deleteSubCategory(subCategoryId);
        return new ResponseEntity<>(b, HttpStatus.OK);
    }
    @GetMapping("/get/all")
    public ResponseEntity<?> getAllSubCategory(){
        List<SubCategory> subCategoryList = subCategoryService.getAllSubCategory();
        return new ResponseEntity<>(subCategoryList, HttpStatus.OK);
    }
}
