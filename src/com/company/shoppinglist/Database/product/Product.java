package com.company.shoppinglist.Database.product;


import java.math.BigDecimal;


public class Product {


    private Long id;
    private String name;
    private BigDecimal price;
    private String description;
    private BigDecimal discount;
    private BigDecimal actualPrice;
    private ProductTypes type;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public BigDecimal getPrice() { return price; }

    public void setPrice(BigDecimal price) {
        this.price = price.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}

    public void setDiscount(BigDecimal discount) {
        if (price.doubleValue() > 20) {
            this.discount = discount;
            this.actualPrice = price.subtract(price.multiply(discount.divide(BigDecimal.valueOf(100.00), 2, BigDecimal.ROUND_HALF_UP))).setScale(2, BigDecimal.ROUND_HALF_UP);
        } else {
            this.discount = new BigDecimal(0.00);
            this.actualPrice = this.price;
        }
    }

    public BigDecimal getDiscount() { return discount; }

    public BigDecimal getActualPrice() { return actualPrice; }

    public void setType(ProductTypes type) { this.type = type; }

    public ProductTypes getType() { return type; }
}