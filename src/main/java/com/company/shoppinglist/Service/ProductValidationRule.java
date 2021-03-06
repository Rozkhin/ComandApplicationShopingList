package com.company.shoppinglist.Service;

import com.company.shoppinglist.Database.product.Product;
import org.springframework.stereotype.Component;

@Component
public interface ProductValidationRule {

    void validate(Product product) throws ProductValidationException;

    default void checkNotNull(Product product) throws ProductValidationException {
        if(product==null){
            throw new ProductValidationException("Product must be not null");
        }
    }
}
