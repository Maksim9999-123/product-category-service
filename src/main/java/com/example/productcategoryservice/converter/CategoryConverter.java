package com.example.productcategoryservice.converter;

import com.example.productcategoryservice.dto.CategoryResponseDto;
import com.example.productcategoryservice.dto.CreateCategoryDto;
import com.example.productcategoryservice.entity.Category;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class CategoryConverter {
    public Category convertDtoToEntity(CreateCategoryDto createCategoryDto){
        return Category.builder()
                .name(createCategoryDto.getName()).build();
    }

    public CategoryResponseDto convertEntityToResponseDto(Category category) {
        return CategoryResponseDto.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }

    public List<CategoryResponseDto> convertEntitiesToResponseDto(List<Category> all) {
        List<CategoryResponseDto> categoryResponseDtos = new ArrayList<>();
        for (Category category : all) {
            categoryResponseDtos.add(convertEntityToResponseDto(category));
        }
        return categoryResponseDtos;
    }
}
