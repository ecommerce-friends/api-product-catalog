package com.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProductCategory {

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	private Integer id;

	@Column(length = 100, nullable = false,  unique = true)
	private String name;

	@Column(length = 500, nullable = true)
	private String description;

	@Column(nullable = false)
	private boolean enabled;

	ProductCategory(){}

	ProductCategory(Integer id, String name, boolean enabled, String description) {
		this.id = id;
		this.name = name;
		this.enabled = enabled;
		this.description = description;
	}

	public Integer getId () {
		return this.id;
	}

	public void setId(Integer id){
		this.id = id;
	}

	public String getName(){
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description){
		this.description = description;
	}


	public boolean getEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

}
