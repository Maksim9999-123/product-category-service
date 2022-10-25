package com.example.productcategoryservice.service;

import com.example.productcategoryservice.entity.Category;
import com.example.productcategoryservice.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<Category> findAllCategory(){
        return categoryRepository.findAll();
    }

    public Optional<Category> findCategoryById(int id){
        return categoryRepository.findById(id);
    }

    public Category createCategory(Category category){
        return categoryRepository.save(category);
    }

    public void updataCategory(Category category){
        categoryRepository.save(category);
    }

    public void deleteById(int id) {
        categoryRepository.deleteById(id);
    }
}
