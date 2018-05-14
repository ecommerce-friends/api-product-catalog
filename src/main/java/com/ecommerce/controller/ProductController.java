package com.ecommerce.controller;

import java.net.URI;
import java.util.Optional;
import java.util.UUID;

import com.ecommerce.model.Product;
import com.ecommerce.service.ProductService;

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
@Api(tags = "Rest API for Product ", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {

	@Autowired
	ProductService productService;

	@PostMapping("product")
	@ApiOperation(value = "Create a product")
	@ApiResponses(value = {
		@ApiResponse(code = 201, message = "Ok", response = Product.class),
		@ApiResponse(code = 400, message = "Bad Request"),
		@ApiResponse(code = 500, message = "Internal Server Error")
	})
	public ResponseEntity<Product> create(@RequestBody Product newProduct) {

		Product product = this.productService.save(newProduct);

		if (product == null)
			return ResponseEntity.noContent().build();

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
			.buildAndExpand(product.getId()).toUri();

		return ResponseEntity.created(location).build();
	}
	
	@ApiOperation(value = "Find all products")
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Ok", response = Product.class),
		@ApiResponse(code = 500, message = "Internal Server Error")
	})
	@GetMapping("product")
	public Iterable<Product> findAll() {
		Iterable<Product> producsCategories = this.productService.findAll();
		return producsCategories;
	}

	@ApiOperation(value = "Find one product")
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Ok", response = Product.class),
		@ApiResponse(code = 404, message = "Not Found", response = Product.class),
		@ApiResponse(code = 500, message = "Internal Server Error")
	})
	@GetMapping("product/{id}")
	public ResponseEntity<Optional<Product>> findOne(@ApiParam(required = true) @PathVariable UUID id) {

		Optional<Product> product = this.productService.findById(id);

		if (!product.isPresent())
			return ResponseEntity.notFound().build();

		return ResponseEntity.ok(product);
	}

	@ApiOperation(value = "Update a product specific")
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Ok", response = Product.class),
		@ApiResponse(code = 404, message = "Not Found", response = Product.class),
		@ApiResponse(code = 500, message = "Internal Server Error")
	})
	@PutMapping("product/{id}")
	public ResponseEntity<Product> update(
		@RequestBody Product productUpdated, 
		@ApiParam(required = true) @PathVariable UUID id
	) {
		
		Product product = this.productService.save(productUpdated);

		if (product == null)
			return ResponseEntity.noContent().build();

		return ResponseEntity.ok(product);
	}

	@ApiOperation(value = "Delete a product specific")
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Ok"),
		@ApiResponse(code = 404, message = "Not Found", response = Product.class),
		@ApiResponse(code = 500, message = "Internal Server Error")
	})
	@DeleteMapping("product/{id}")
	public void delete(@ApiParam(required = true) @PathVariable UUID id) {
		this.productService.delete(id);
	}

}
