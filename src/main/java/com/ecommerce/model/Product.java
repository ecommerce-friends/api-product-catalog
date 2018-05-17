package com.ecommerce.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
public class Product implements Serializable {

	private static final long serialVersionUID = -40608366138121970L;

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	private UUID id;

	@Column(length = 100, nullable = false,  unique = true)
	private String name;

	@Column(length = 500, nullable = true)
	private String description;

	@Column(nullable = false)
	private boolean enabled;

	@ManyToOne
	@JoinColumn(name = "product_category_id")
	private ProductCategory productCategory;

	@ManyToOne
	@JoinColumn(name = "brand_id")
	private Brand brand;
    
}
