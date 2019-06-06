package com.company.shoppinglist.Service;

import com.company.shoppinglist.Database.product.Product;

import java.util.HashSet;
import java.util.Set;

public class ProductValidationService {
    private Set<ProductValidationRule> validationRules = new HashSet<>();

    public ProductValidationService(){
        validationRules.add(new ProductNameValidationRule());
        validationRules.add(new ProductDiscountValidationRule());
    }

    public Boolean validate(Product product){
        Boolean result = true;
        for (ProductValidationRule s : validationRules) {
            try {
                s.validate(product);
            } catch (ProductValidationException e) {

                System.out.println(e.getMessage());
                result = false;
            }
        }
        return result;
    }
}



