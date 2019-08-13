package com.company.shoppinglist.web;

import com.WebShopping.Repository.Product;
import com.company.shoppinglist.Database.product.Product;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartDTO {
    @NotNull(groups = Update.class)
    @Null(groups = Create.class)
    private Long id;
    @NotEmpty(groups = {Create.class, Update.class}, message = "Name must be not blank.")
    @Length(groups = {Create.class, Update.class}, min = 3, message = "Name must be at least 3 sym.")
    private String name;
    private String description;
    private List<Product> productList = new ArrayList<>();

    public ShoppingCartDTO() {
    }

    public ShoppingCartDTO(Long id, String name, String description, List<Product> productList) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.productList = productList;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public void changeToInternalProductId() {
        for (int i = 0; i < productList.size(); i++) {
            productList.get(i).setId((long) i);
        }
    }

    public interface Create {
    }

    public interface Update {
    }
}
