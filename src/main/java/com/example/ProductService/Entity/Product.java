package com.example.ProductService.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID productId;
    public String title;
    @Column(length = 1024)
    public String description;
    public List<String> urls;
    public String brandName;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "sub_category_id")
    public SubCategory subCategory;
}
