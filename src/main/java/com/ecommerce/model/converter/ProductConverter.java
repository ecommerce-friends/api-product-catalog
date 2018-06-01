package com.ecommerce.model.converter;

import com.ecommerce.model.Product;
import com.ecommerce.model.json.ProductJson;

public class ProductConverter {


    public static Product converterToProductCategory(ProductJson productCategoryJson) {

        return Product.builder()
                .name(productCategoryJson.getName().trim())
                .description(productCategoryJson.getDescription().trim())
                .enabled(true)
                .build();
    }

}
