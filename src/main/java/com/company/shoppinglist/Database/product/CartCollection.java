package com.company.shoppinglist.Database.product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartCollection {

    Map<Long, Cart> cartRepository = new HashMap<>();
    private Long productIdSequence = 0L;

    public void insert(Cart cart) {
        cart.setId(productIdSequence);
        cartRepository.put(productIdSequence, cart);
        productIdSequence++;

    }

    public Cart Getcart(Long id){
        Cart tmpcart=cartRepository.get(id);
        return tmpcart;
    }

    public Map<Long, Cart> getAllcarts(){
        return cartRepository;
    }
}
