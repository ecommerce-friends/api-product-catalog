package com.ecommerce.controller;

import java.net.URI;
import java.util.Optional;

import com.ecommerce.model.ProductCategory;
import com.ecommerce.service.ProductCategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController()
public class ProductCategoryController {

	@Autowired
	ProductCategoryService productCategoryService;

	@PostMapping("product-category")
	public ResponseEntity<ProductCategory> create(@RequestBody ProductCategory newProductCategory) {
		ProductCategory productCategory = this.productCategoryService.save(newProductCategory);

		if (productCategory == null)
			return ResponseEntity.noContent().build();

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
			.buildAndExpand(productCategory.getId()).toUri();

		return ResponseEntity.created(location).build();
	}
	
	@GetMapping("product-category")
	public Iterable<ProductCategory> findAll() {
		Iterable<ProductCategory> producsCategories = this.productCategoryService.findAll();
		return producsCategories;
	}

	@GetMapping("product-category/{id}")
	public ResponseEntity<Optional<ProductCategory>> findOne(@PathVariable Integer id) {
		Optional<ProductCategory> productCategory = this.productCategoryService.findById(id);

		if (!productCategory.isPresent())
			return ResponseEntity.notFound().build();

		return ResponseEntity.ok(productCategory);
	}

	@PutMapping("product-category/{id}")
	public ResponseEntity<ProductCategory> update(@RequestBody ProductCategory productCategoryUpdated, @PathVariable Integer id) {
		ProductCategory productCategory = this.productCategoryService.save(productCategoryUpdated);

		if (productCategory == null)
			return ResponseEntity.noContent().build();

		return ResponseEntity.ok(productCategory);
	}

	@DeleteMapping("product-category/{id}")
	public void delete(@PathVariable Integer id) {
		this.productCategoryService.delete(id);
	}

}
