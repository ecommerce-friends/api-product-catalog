package com.ecommerce.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	private UUID id;

	@Column(length = 100, nullable = false,  unique = true)
	private String name;

	@Column(length = 500, nullable = true)
	private String description;

	@Column(nullable = false)
    private boolean enabled;
    
}
