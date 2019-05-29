package com.company.shoppinglist.Service;

import com.company.shoppinglist.Database.product.Product;


import java.math.BigDecimal;

public class ProductDiscountValidationRule extends ProductNameValidationRule implements ProductValidationRule{

    @Override
    public void validate(Product product) throws ProductValidationException {
        BigDecimal max = BigDecimal.valueOf(80);
        //BigDecimal min = BigDecimal.valueOf(20);
        if((product.getDiscount().compareTo(max))>0) throw new ProductValidationException("Discount must be lower than 80%");
        //if((product.getDiscount().compareTo(min))<0) throw new ProductValidationException("Discount must be greater than 20%");

    }

    @Override
    public void checkNotNull(Product product) throws ProductValidationException {

    }
}
