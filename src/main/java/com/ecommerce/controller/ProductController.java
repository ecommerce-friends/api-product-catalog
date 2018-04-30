package com.ecommerce.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	
	@RequestMapping("product")
	public String findAll() {
		return "Product its working";
	}
	
	

}
