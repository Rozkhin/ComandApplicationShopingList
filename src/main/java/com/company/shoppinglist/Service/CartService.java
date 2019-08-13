package com.company.shoppinglist.Service;

import com.company.shoppinglist.Database.product.Cart;
import com.company.shoppinglist.Database.product.CartRep;
import com.company.shoppinglist.Database.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
@Component
public class CartService {
    public CartRep cartList;
    Cart currentCart;
@Autowired
    public CartService(CartRep cartList) {
        this.cartList = cartList;
    }

    public Long Newcart(String Name, String descr) {
        currentCart=new Cart();
        currentCart.setName(Name);
        currentCart.setDescription(descr);
        savecart(currentCart);
        return currentCart.getId();
    }

    public void SetCart(Cart cart){
        this.currentCart=cart;
    }

    public Cart getCurrentcart(){
        if(currentCart!=null) {
            return currentCart;
        }else {
            System.out.println("Create a cart or load it");
            return null;
        }
    }

    public ArrayList<Product> getCurrentCartProducts(){
        return currentCart.GetRepository();
    }

    public void deleteProductFromCurrentCart(Integer id1){
        currentCart.deleteproduct(id1);
    }

    public void savecart(Cart cart){
        cartList.insert(cart);
    }

    public  Map<Long, Cart> getallcardsfromrep(){
        Map<Long, Cart> tmprep= cartList.getAllcarts();
        return tmprep;
    }

    public void loadCart(Long id){
        currentCart=cartList.Getcart(id);
    }

    public void deletecart(Long id){
        cartList.deleteCart(id);
    }


   }
