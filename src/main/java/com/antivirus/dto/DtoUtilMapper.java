package com.antivirus.dto;

import com.antivirus.entity.Product;
import com.antivirus.entity.Region;

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
        List<ProductDto> ProductDtos = new ArrayList<>();

        for (Product product: products)
        {
            ProductDto productDto= productToProductDto(product);
            ProductDtos.add(productDto);
        }
        return ProductDtos;
    }
    public static RegionDTO regionToRegionDTO(Region region){
        return  new RegionDTO(region.getId(), region.getName());
    }
    public static List<RegionDTO> regionsToRegionsDTO(List<Region> regions)
    {
        List<RegionDTO> regionDtos = new ArrayList<>();

        for (Region region: regions)
        {
            RegionDTO regionDTO = regionToRegionDTO(region);
            regionDtos.add(regionDTO);
        }
        return regionDtos;
    }
}
