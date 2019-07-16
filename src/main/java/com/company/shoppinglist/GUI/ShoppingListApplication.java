package com.company.shoppinglist.GUI;

import com.company.shoppinglist.Config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class ShoppingListApplication {

    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        ConsoleI consoleI = ctx.getBean(ConsoleI.class);
        consoleI.execute();
       // ProductCollection repository= new ProductCollection();

       // Set<ProductValidationRule> validationRules = new HashSet<>();
       // validationRules.add(new ProductNameValidationRule(repository));
       // validationRules.add(new ProductDiscountValidationRule());

       // ProductValidationService productValidationService=new ProductValidationService(validationRules);
       // ProductService productService = new ProductService(repository,productValidationService);

       // ProductCollection ShopingList = new ProductCollection();
       // ShopingListService shopservice = new ShopingListService(ShopingList);

       // ConsoleI consoleUI = new ConsoleI(productService,shopservice);
       // consoleUI.execute();
    }
}
