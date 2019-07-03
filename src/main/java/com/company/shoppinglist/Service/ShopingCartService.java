package com.company.shoppinglist.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShopingCartService {
    ShopingCartInterfeice shopingCartInterfeice ;
@Autowired
    public ShopingCartService(ShopingCartInterfeice shopingCartInterfeice) {
        this.shopingCartInterfeice = shopingCartInterfeice;
    }
}
