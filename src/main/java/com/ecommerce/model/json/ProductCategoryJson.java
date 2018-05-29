package com.ecommerce.model.json;

import lombok.Data;

@Data
public class ProductCategoryJson {

    private String id;
    private String name;
    private String description;
    private boolean enabled;

}
