package com.ecommerce.model.converter;

import com.ecommerce.model.ProductCategory;
import com.ecommerce.model.json.ProductCategoryJson;

public class ProductCategoryConverter {

    public static ProductCategory converterToProductCategory(ProductCategoryJson productCategoryJson) {
        return ProductCategory.builder()
                .name(productCategoryJson.getName().trim())
                .description(productCategoryJson.getDescription().trim())
                .enabled(true)
                .build();
    }
}
