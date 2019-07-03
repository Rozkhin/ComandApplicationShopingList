package com.company.shoppinglist.Service;

import com.company.shoppinglist.Database.product.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Component
public class ShopingCardList implements ShopingCartInterfeice {


   Map<Long,ShopingCard> CartList = new HashMap<>();
   private Long CartIdSequence = 0L;

   public ShopingCard shopingCard=null;

   public ShopingCard insert(ShopingCard sc) {
        sc.setId(CartIdSequence);
        CartList.put(CartIdSequence, sc);
        CartIdSequence++;
        shopingCard=sc;
        return sc;
    }

    public ShopingCard findCartById(Long id) {
        return CartList.get(id);
    }

    public List<Long> getallids() {
        ArrayList<Long> idlist = new ArrayList<>();
        for (Map.Entry<Long, ShopingCard> n : CartList.entrySet()) {
            Long id = n.getKey();
            idlist.add(id);
        }
        return idlist;
    }


}
