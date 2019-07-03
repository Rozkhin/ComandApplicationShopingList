package com.company.shoppinglist.Service;

import java.util.List;

public interface ShopingCartInterfeice {
    public ShopingCard insert(ShopingCard sc);

    public ShopingCard findCartById(Long id);

    public List<Long> getallids();
}
