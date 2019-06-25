package com.company.shoppinglist.Service;

import com.company.shoppinglist.Database.product.Collection;
import com.company.shoppinglist.Database.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShopingListService {
    Collection shopinglist;
@Autowired
    public ShopingListService(Collection shopinglist) {
        this.shopinglist = shopinglist;
    }

    public void AddproductByIdToShopingList(Product product){
        shopinglist.insert(product);
        System.out.println("Product added vs id ");
    }

    public void ShowAllList(){
        shopinglist.getallids();
    }

}
