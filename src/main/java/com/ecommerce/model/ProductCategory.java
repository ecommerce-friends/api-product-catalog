package com.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class ProductCategory {
	
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	private String id;

	@Column(length = 100, nullable = false, unique = true)
	private String name;

	@Column(nullable = false)
	private boolean enabled;

	ProductCategory(){}

	ProductCategory(String name, boolean enabled) {
		this.name = name;
		this.enabled = enabled;
	}

}
