package com.company.shoppinglist.Service;

import com.company.shoppinglist.Database.product.Product;

public class ProductNameValidationRule implements ProductValidationRule{
    @Override
    public void validate(Product product) throws ProductValidationException {
        checkNotNull(product);
        if(product.getName()==null) throw new ProductValidationException("Task name must not null");
        if (product.getName().length()<3) throw new ProductValidationException("Name must be longer than 3");
        if(product.getName().length()>25) throw new ProductValidationException("Name must be shorter than 25");
    }
}

