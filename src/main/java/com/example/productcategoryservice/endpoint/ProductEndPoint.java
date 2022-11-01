package com.example.productcategoryservice.endpoint;

import com.example.productcategoryservice.dto.CreateProductDto;
import com.example.productcategoryservice.dto.ProductResponseDto;
import com.example.productcategoryservice.entity.Category;
import com.example.productcategoryservice.entity.Product;
import com.example.productcategoryservice.mapper.ProductMapper;
import com.example.productcategoryservice.repository.ProductRepository;
import com.example.productcategoryservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductEndPoint {
    private final ProductService productService;

    private final ProductMapper productMapper;

    @GetMapping("/all")
    public List<ProductResponseDto> getAllProducts(){
        return productMapper.map(productService.findAllProduct());
    }

    @GetMapping("/getBy/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") int id){
        Optional<Product> byId = productService.findProductById(id);
        if(byId.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(byId.get());
    }

    @PostMapping("/reate")
    public ResponseEntity<?> createProduct(@RequestBody CreateProductDto createProductDto){
        Product saveProduct = productService.createProduct(productMapper.map(createProductDto));
        return ResponseEntity.ok(saveProduct);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
        if(product.getId() == 0){
            return ResponseEntity.badRequest().build();
        }
        productService.updateProduct(product);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProductById(@PathVariable("id") int id){
        productService.deleteById(id);
        return ResponseEntity.notFound().build();
    }
}
