package com.ecommerce.service;

import java.util.Optional;
import java.util.UUID;

import com.ecommerce.model.Product;
import com.ecommerce.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(UUID id) {
        return productRepository.findById(id);
    }

    public void delete(UUID id) {
        productRepository.deleteById(id);
    }
}