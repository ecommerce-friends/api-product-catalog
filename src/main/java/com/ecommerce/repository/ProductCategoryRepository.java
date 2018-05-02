package com.ecommerce.repository;

import java.util.List;

import com.ecommerce.model.ProductCategory;

import org.springframework.data.repository.CrudRepository;

public interface ProductCategoryRepository extends CrudRepository<ProductCategory, String> {

}
