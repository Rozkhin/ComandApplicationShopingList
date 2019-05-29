package com.company.shoppinglist.Service;

import com.company.shoppinglist.Database.product.Product;

import java.math.BigDecimal;

public class ProductDiscountValidationRule implements ProductValidationRule{
    @Override
    public void validate(Product product) throws ProductValidationException {
        if((product.getDiscount().compareTo(BigDecimal.valueOf(80)))>0)
            throw new ProductValidationException("Discount must be lower than 80%");
        if((product.getDiscount().compareTo(BigDecimal.valueOf(20)))<0)
            throw new ProductValidationException("Discount must be greater than 20%");

    }

}
