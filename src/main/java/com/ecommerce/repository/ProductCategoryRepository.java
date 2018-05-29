package com.ecommerce.repository;


import com.ecommerce.model.ProductCategory;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductCategoryRepository extends CrudRepository<ProductCategory, String> {

    List<ProductCategory> findByName(String name);

}
