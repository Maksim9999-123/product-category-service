package com.example.productcategoryservice.dto;


import com.example.productcategoryservice.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
public class CreateProductDto {
    private String title;
    private int count;
    private double price;
    private Category category;
}
