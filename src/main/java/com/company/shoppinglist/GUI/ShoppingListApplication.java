package com.company.shoppinglist.GUI;

import com.company.shoppinglist.Database.product.Collection;
import com.company.shoppinglist.Service.*;

import java.util.HashSet;
import java.util.Set;

class ShoppingListApplication {

    public static void main(String[] args) {
        Collection repository= new Collection();


        Set<ProductValidationRule> validationRules = new HashSet<>();

        validationRules.add(new ProductNameValidationRule(repository));
        validationRules.add(new ProductDiscountValidationRule());

        ProductValidationService productValidationService=new ProductValidationService(validationRules);
        ProductService productService = new ProductService(repository,productValidationService);

        Collection ShopingList = new Collection();
        ShopingListService shopservice = new ShopingListService(ShopingList);

        ConsoleI consoleUI = new ConsoleI(productService,shopservice);
        consoleUI.execute();
    }
}
