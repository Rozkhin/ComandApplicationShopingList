package com.company.shoppinglist.Database.product;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
@Profile("inmemory")
@Component
public class CartCollection implements CartRep{

    Map<Long, Cart> cartRepository = new HashMap<>();
    private Long productIdSequence = 0L;


    @Override
    public boolean existbyName(String productName) {
        return false;
    }

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

    public void deleteCart(Long shoppingCartId) {
        cartRepository.remove(shoppingCartId);
    }
}

