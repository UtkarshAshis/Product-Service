package com.example.ProductService.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class SubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID id;
    public String name;
    @Column(length = 1024)
    public String descriptions;
    @JsonManagedReference
    @OneToMany(mappedBy = "subCategory", cascade = CascadeType.ALL)
    public List<Product> productList = new ArrayList<>();
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "category_id")
    public Category category;
}
