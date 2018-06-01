package com.ecommerce.model.json;

import lombok.Data;

@Data
public class ProductJson {

    private String id;
    private String name;
    private String description;
    private String idProductCategory;
    private boolean enabled;

}
