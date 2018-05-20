package com.ecommerce.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;

@RestController
public class SwaggerController {

	@RequestMapping(method = RequestMethod.GET)
	public ApiInfo swaggerUi() {
		return metaData();
	}
	
	private ApiInfo metaData() {
        return new ApiInfoBuilder()
        	.title("Spring Boot REST API")
            .description("\"Spring Boot REST API for Online Store\"")
            .version("1.0.0")
            .license("Apache License Version 2.0")
            .build();
	}
}
