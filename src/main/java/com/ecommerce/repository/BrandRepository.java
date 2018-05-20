package com.ecommerce.repository;

import java.util.UUID;

import com.ecommerce.model.Brand;

import org.springframework.data.repository.CrudRepository;

public interface BrandRepository extends CrudRepository<Brand, UUID> {

}