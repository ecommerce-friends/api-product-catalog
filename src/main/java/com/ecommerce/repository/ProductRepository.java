package com.ecommerce.repository;

import java.util.UUID;

import com.ecommerce.model.Product;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, UUID> {}
