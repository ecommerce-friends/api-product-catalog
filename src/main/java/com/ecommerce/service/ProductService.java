package com.ecommerce.service;

import java.util.Optional;
import java.util.stream.Stream;

import com.ecommerce.model.Product;
import com.ecommerce.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Stream<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable).stream();
    }

    public Optional<Product> findById(String id) {
        return productRepository.findById(id);
    }

    public void delete(String id) {
        productRepository.deleteById(id);
    }
}