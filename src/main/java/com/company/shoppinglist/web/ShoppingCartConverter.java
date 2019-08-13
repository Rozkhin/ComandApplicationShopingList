package com.company.shoppinglist.web;


import com.company.shoppinglist.Database.product.Cart;

public class ShoppingCartConverter {
    public static Cart convert(ShoppingCartDTO shoppingCartDTO) {
        Cart shoppingCart = new Cart();
        shoppingCart.setId(shoppingCartDTO.getId());
        shoppingCart.setName(shoppingCartDTO.getName());
        shoppingCart.setDescription(shoppingCartDTO.getDescription());
        shoppingCart.setProductList(shoppingCartDTO.getProductList());
        return shoppingCart;
    }

    public static ShoppingCartDTO convert(Cart shoppingCart) {
        ShoppingCartDTO shoppingCartDTO = new ShoppingCartDTO();
        shoppingCartDTO.setId(shoppingCart.getId());
        shoppingCartDTO.setName(shoppingCart.getName());
        shoppingCartDTO.setDescription(shoppingCart.getDescription());
        shoppingCartDTO.setProductList(shoppingCart.getProductList());
        return shoppingCartDTO;
    }
}
