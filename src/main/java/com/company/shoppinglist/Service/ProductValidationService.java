package com.company.shoppinglist.Service;

import com.company.shoppinglist.Database.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class ProductValidationService {


    private Set<ProductValidationRule> validationRules;
@Autowired
    public ProductValidationService(Set<ProductValidationRule> productColection) {
        this.validationRules = productColection;
        System.out.println("Validation service is started");
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



