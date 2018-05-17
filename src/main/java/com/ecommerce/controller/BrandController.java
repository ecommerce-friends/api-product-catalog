package com.ecommerce.controller;

import java.net.URI;

import com.ecommerce.model.Brand;
import com.ecommerce.model.Product;
import com.ecommerce.repository.BrandRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(name = "brand")
@Api(tags = "Rest API for Brands ", produces = MediaType.APPLICATION_JSON_VALUE)
public class BrandController {

	@Autowired
	BrandRepository brandRepository;

	@PostMapping()
	@ApiOperation(value = "Create a brand")
	@ApiResponses(value = {
		@ApiResponse(code = 201, message = "Ok", response = Brand.class),
		@ApiResponse(code = 400, message = "Bad Request"),
		@ApiResponse(code = 500, message = "Internal Server Error")
	})
	public ResponseEntity<Product> create(@RequestBody Brand newBrand) {

		Brand brand = this.brandRepository.save(newBrand);

		if (brand == null)
			return ResponseEntity.noContent().build();

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
			.buildAndExpand(brand.getId()).toUri();

		return ResponseEntity.created(location).build();
	}
	
	@ApiOperation(value = "Find all brands")
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Ok", response = Brand.class),
		@ApiResponse(code = 500, message = "Internal Server Error")
	})
	@GetMapping()
	public Iterable<Brand> findAll() {
		Iterable<Brand> brands = this.brandRepository.findAll();
		return brands;
	}

}
