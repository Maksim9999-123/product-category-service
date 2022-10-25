package com.example.productcategoryservice.endpoint;
import com.example.productcategoryservice.converter.CategoryConverter;
import com.example.productcategoryservice.dto.CategoryResponseDto;
import com.example.productcategoryservice.dto.CreateCategoryDto;
import com.example.productcategoryservice.entity.Category;
import com.example.productcategoryservice.mapper.CategoryMapper;
import com.example.productcategoryservice.repository.CategoryRepository;
import com.example.productcategoryservice.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class CategoryEndPoint {
    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @GetMapping("/categories")
    public List<CategoryResponseDto> getAllCategories(){
        return categoryMapper.map(categoryService.findAllCategory());
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<Category> getcategoryById(@PathVariable("id") int id){
        Optional<Category> byId = categoryService.findCategoryById(id);
        if(byId.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(byId.get());
    }

    @PostMapping("/category")
    public ResponseEntity<?> createCategory(@RequestBody CreateCategoryDto createCategoryDto){
        Category saveCategory = categoryService.createCategory(categoryMapper.map(createCategoryDto));
        return ResponseEntity.ok(saveCategory);
    }

    @PutMapping("/categories")
    public ResponseEntity<Category> updatecategory(@RequestBody Category category){
        if(category.getId() == 0){
            return ResponseEntity.badRequest().build();
        }
        categoryService.updataCategory(category);
        return ResponseEntity.ok(category);
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity<?> deletecategoryById(@PathVariable("id") int id){
        categoryService.deleteById(id);
        return ResponseEntity.notFound().build();
    }
}
