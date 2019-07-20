package com.company.shoppinglist.Database.product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartCollection implements Collection{

    Map<Long, Cart> cartRepository = new HashMap<>();
    private Long productIdSequence = 0L;

    @Override
    public Product insert(Product product) {
        return null;
    }

    @Override
    public Product findProductById(Long id) {
        return null;
    }

    @Override
    public Product findCardById(Long id) {
        return null;
    }

    @Override
    public List<Long> getallids() {
        return null;
    }

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
}
