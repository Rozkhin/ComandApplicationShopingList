package com.company.shoppinglist.web;


import com.company.shoppinglist.Database.product.ProductTypes;

import java.math.BigDecimal;

public class ProductDTO {
    private Long id;
    private String name;
    private BigDecimal price;
    private String description;
    private BigDecimal discount;
    private BigDecimal actualPrice;
    private ProductTypes type;

    public ProductDTO() {
    }

    public ProductDTO(Long id, String name, BigDecimal price, String description, BigDecimal discount, BigDecimal actualPrice, ProductTypes type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.discount = discount;
        this.actualPrice = actualPrice;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(BigDecimal actualPrice) {
        this.actualPrice = actualPrice;
    }

    public ProductTypes getType() {
        return type;
    }

    public void setType(ProductTypes type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return this.getId() + " | "
                + this.getName() + " | "
                + this.getPrice() + " | "
                + this.getType().toString() + " | "
                + this.getDiscount() + " | "
                + this.getActualPrice() + " | "
                + this.getDescription();
    }
}
