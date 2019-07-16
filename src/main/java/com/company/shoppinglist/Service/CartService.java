package com.company.shoppinglist.Service;

import com.company.shoppinglist.Database.product.Cart;
import com.company.shoppinglist.Database.product.CartCollection;
import com.company.shoppinglist.Database.product.Product;
import org.springframework.stereotype.Component;

import java.util.*;
@Component
public class CartService {
    public CartCollection cartList = new CartCollection();
    Cart currentCart;

    public void Newcart(String Name,String descr) {
        currentCart=new Cart();
        currentCart.setName(Name);
        currentCart.setDescription(descr);
        savecart();
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

    public Map<Long, Product> getCurrentCartProducts(){
        return currentCart.GetRepository();
    }

    public void deleteProductFromCurrentCart(Long id1){
        currentCart.deleteproduct(id1);
    }

    public void savecart(){
        cartList.insert(currentCart);
    }

    public  Map<Long, Cart> getallcardsfromrep(){
        Map<Long, Cart> tmprep= cartList.getAllcarts();
        return tmprep;
    }
    public void loadCart(Long id){
        currentCart=cartList.Getcart(id);
    }

   }
