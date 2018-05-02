package com.ecommerce.controller;

import com.ecommerce.model.ProductCategory;
import com.ecommerce.repository.ProductCategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

	//@Autowired
	//ProductCategoryRepository repository;
	
	@RequestMapping("product")
	public String findAll() {
		return "test";//this.repository.findAll();
	}
	
	

}
