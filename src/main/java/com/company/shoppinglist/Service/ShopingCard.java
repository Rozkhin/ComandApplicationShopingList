package com.company.shoppinglist.Service;

import com.company.shoppinglist.Database.product.Collection;
import com.company.shoppinglist.Database.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class ShopingCard {
    Collection shopinglist;
    String name;
    Long id;
    String descr;
    public Collection Cart = new Collection();

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

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }


}
