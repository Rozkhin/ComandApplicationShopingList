package com.company.shoppinglist.Database.product;

import org.hibernate.annotations.*;
import org.hibernate.mapping.Table;

import javax.persistence.*;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@javax.persistence.Table(name = "Product")
public class Product {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "description")
    private String description;

    @Column(name = "discount")
    private BigDecimal discount;

    @Column(name = "actualPrice")
    private BigDecimal actualPrice;

    @Column(name = "type")
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
        if (price.compareTo(BigDecimal.valueOf(20.00)) >= 0) {
            this.discount = discount.setScale(1, BigDecimal.ROUND_HALF_UP);
            this.actualPrice = price.subtract(price.multiply(discount.divide(BigDecimal.valueOf(100.00), 2, BigDecimal.ROUND_HALF_UP))).setScale(2, BigDecimal.ROUND_HALF_UP);
        } else {
            this.discount = new BigDecimal(0.0);
            this.actualPrice = this.price;
        }
    }

    public BigDecimal getDiscount() { return discount; }

    public BigDecimal getActualPrice() { return actualPrice; }

    public void setType(ProductTypes type) { this.type = type; }

    public ProductTypes getType() { return type; }
}