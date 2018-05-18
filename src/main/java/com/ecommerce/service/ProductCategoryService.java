package com.ecommerce.service;

import java.util.Optional;

import com.ecommerce.model.ProductCategory;
import com.ecommerce.repository.ProductCategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    public ProductCategory save(ProductCategory productCategory) {
        return productCategoryRepository.save(productCategory);
    }

    public Iterable<ProductCategory> findAll() {
        return productCategoryRepository.findAll();
    }

    public Optional<ProductCategory> findById(String id) {
        return productCategoryRepository.findById(id);
    }

    public void delete(String id) {
        productCategoryRepository.deleteById(id);
    }
}