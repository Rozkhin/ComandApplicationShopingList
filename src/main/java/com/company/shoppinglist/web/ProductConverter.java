package com.company.shoppinglist.web;


import com.company.shoppinglist.Database.product.Product;

public class ProductConverter {
    public static Product convert(ProductDTO productDTO) {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setDiscount(productDTO.getDiscount());
        product.setType(productDTO.getType());
        return product;
    }
    public static ProductDTO convert(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());
        productDTO.setPrice(product.getPrice());
        productDTO.setDiscount(product.getDiscount());
        productDTO.setActualPrice(product.getActualPrice());
        productDTO.setType(product.getType());
        return productDTO;
    }
}
