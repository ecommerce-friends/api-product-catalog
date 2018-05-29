package com.ecommerce.service;

import java.util.List;
import java.util.Optional;

import com.ecommerce.model.ProductCategory;
import com.ecommerce.repository.ProductCategoryRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public ProductCategory save(ProductCategory productCategory) {

        try {
            log.info("Starting create a Product Cateory");
            return productCategoryRepository.save(productCategory);

        } catch (Exception ex) {
            log.error(ex.getMessage());
            throw ex;
        }
    }

    public Iterable<ProductCategory> findAll() {
        return productCategoryRepository.findAll();
    }

    public List<ProductCategory> findByName(String name) {
        return productCategoryRepository.findByName(name);
    }

    public Optional<ProductCategory> findById(String id) {
        return productCategoryRepository.findById(id);
    }

    public void delete(String id) {
        productCategoryRepository.deleteById(id);
    }

    public boolean verifyIfExistByName(String name) {
        return this.findByName(name).stream()
                .anyMatch(productCategory -> productCategory.getName().toLowerCase().equals(name.toLowerCase()));
    }
}