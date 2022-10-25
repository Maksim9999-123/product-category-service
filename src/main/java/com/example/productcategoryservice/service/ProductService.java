package com.example.productcategoryservice.service;

import com.example.productcategoryservice.entity.Product;
import com.example.productcategoryservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> findAllProduct() {
        return productRepository.findAll();
    }

    public Optional<Product> findProductById(int id) {
        return productRepository.findById(id);
    }

    public Product createProduct(Product map) {
        return productRepository.save(map);
    }

    public void updateProduct(Product product) {
        productRepository.save(product);
    }

    public void deleteById(int id) {
        productRepository.deleteById(id);
    }
}
