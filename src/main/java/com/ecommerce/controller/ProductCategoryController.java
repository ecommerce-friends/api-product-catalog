package com.ecommerce.controller;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import com.ecommerce.model.Product;
import com.ecommerce.model.ProductCategory;
import com.ecommerce.model.converter.ProductCategoryConverter;
import com.ecommerce.model.json.ProductCategoryJson;
import com.ecommerce.service.ProductCategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(tags = "Rest API for Product Category", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductCategoryController {

	@Autowired
	ProductCategoryService productCategoryService;

	@PostMapping("product-category")
	@ApiOperation(value = "Create a product category")
	@ApiResponses(value = {
		@ApiResponse(code = 201, message = "Ok", response = ProductCategory.class),
		@ApiResponse(code = 400, message = "Bad Request"),
		@ApiResponse(code = 500, message = "Internal Server Error")
	})
	public ResponseEntity<ProductCategory> create(@RequestBody ProductCategoryJson productCategoryJson) {

		ProductCategory productCategory = ProductCategoryConverter.converterToProductCategory(productCategoryJson);

		boolean existProductCategory = this.productCategoryService.verifyIfExistByName(productCategory.getName());

		if (existProductCategory)
			return ResponseEntity.badRequest().build();

		productCategory = this.productCategoryService.save(productCategory);

		if (productCategory == null)
			return ResponseEntity.noContent().build();

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
			.buildAndExpand(productCategory.getId()).toUri();

		return ResponseEntity.created(location).body(productCategory);
	}
	
	@ApiOperation(value = "Find all product categories")
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Ok", response = ProductCategory.class),
		@ApiResponse(code = 500, message = "Internal Server Error")
	})
	@GetMapping("product-category")
	public Iterable<ProductCategory> findAll() {
		Iterable<ProductCategory> producsCategories = this.productCategoryService.findAll();
		return producsCategories;
	}

	@ApiOperation(value = "Find one product category")
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Ok", response = ProductCategory.class),
		@ApiResponse(code = 404, message = "Not Found", response = ProductCategory.class),
		@ApiResponse(code = 500, message = "Internal Server Error")
	})
	@GetMapping("product-category/{id}")
	public ResponseEntity<Optional<ProductCategory>> findOne(@ApiParam(required = true) @PathVariable String id) {

		Optional<ProductCategory> productCategory = this.productCategoryService.findById(id);

		if (!productCategory.isPresent())
			return ResponseEntity.notFound().build();

		return ResponseEntity.ok(productCategory);
	}

	@ApiOperation(value = "Update a product category specific")
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Ok", response = ProductCategory.class),
		@ApiResponse(code = 404, message = "Not Found", response = ProductCategory.class),
		@ApiResponse(code = 500, message = "Internal Server Error")
	})
	@PutMapping("product-category/{id}")
	public ResponseEntity<ProductCategory> update(@RequestBody ProductCategory productCategoryUpdated, 
		@ApiParam(required = true) @PathVariable String id) {
		
		ProductCategory productCategory = this.productCategoryService.save(productCategoryUpdated);

		if (productCategory == null)
			return ResponseEntity.noContent().build();

		return ResponseEntity.ok(productCategory);
	}

	@ApiOperation(value = "Delete a product category specific")
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Ok"),
		@ApiResponse(code = 404, message = "Not Found", response = ProductCategory.class),
		@ApiResponse(code = 500, message = "Internal Server Error")
	})
	@DeleteMapping("product-category/{id}")
	public void delete(@ApiParam(required = true) @PathVariable String id) {
		this.productCategoryService.delete(id);
	}

}
