package com.company.shoppinglist.Database.product;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface CartRep {


    public boolean existbyName(String productName) ;

    public void insert(Cart cart);

    public Cart Getcart(Long id);

    public Map<Long, Cart> getAllcarts();

    public void deleteCart(Long id);
}
