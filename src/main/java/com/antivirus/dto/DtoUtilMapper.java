package com.antivirus.dto;

import com.antivirus.entity.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 7/26/2017.
 */
public class DtoUtilMapper {

    public static ProductDto productToProductDto(Product product){
        return new ProductDto(product.getId(), product.getName(), product.getDescription(), product.getPrice(),
                product.getQuantityPC(), product.getLicenceDurationYears(), product.getProductQuantity(),
                product.getPathImage());

    }

    public static List<ProductDto> productsToProductsDto(List<Product> products)
    {
        List<ProductDto> itemDtos = new ArrayList<>();

        for (Product product: products)
        {
            ProductDto productDto= productToProductDto(product);
            itemDtos.add(productDto);
        }
        return itemDtos;
    }
}
