package com.company.shoppinglist.Service;

import com.company.shoppinglist.Database.product.Collection;
import com.company.shoppinglist.Database.product.Product;

public class ShopingListService {
    Collection shopinglist;

    public ShopingListService(Collection shopinglist) {
        this.shopinglist = shopinglist;
    }

    public void AddproductByIdToShopingList(Product product){
        shopinglist.insert(product);
    }

    public void ShowAllList(){
        shopinglist.getallids();
    }

}
