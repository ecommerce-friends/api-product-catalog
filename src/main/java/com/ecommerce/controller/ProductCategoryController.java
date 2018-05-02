package com.ecommerce.controller;

import com.ecommerce.repository.ProductCategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller("product-category")
public class ProductCategoryController {

	@Autowired
	ProductCategoryRepository productCategoryRepository;

	@PostMapping()
	public String create() {
		return "Product Category POST its working";
	}
	
	@GetMapping()
	public String findAll() {
		return "Product Category FIND ALL its working";
	}

	@GetMapping("/{id}")
	public String findOne() {
		return "Product Category FIND ONE its working";
	}

	@PutMapping()
	public String update() {
		return "Product Category UPDATE its working";
	}

	@DeleteMapping("/{id}")
	public String delete() {
		return "Product Category DELETE its working";
	}

}
