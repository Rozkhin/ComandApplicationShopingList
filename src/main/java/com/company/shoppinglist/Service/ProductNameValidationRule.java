package com.company.shoppinglist.Service;

import com.company.shoppinglist.Database.product.Collection;
import com.company.shoppinglist.Database.product.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductNameValidationRule implements ProductValidationRule{

    private final Collection repository;

    public ProductNameValidationRule(Collection repository) {
        this.repository=repository;
    }

    @Override
    public void validate(Product product) throws ProductValidationException {
        checkNotNull(product);
        if(product.getName()==null) throw new ProductValidationException("Task name must not null");
        if (product.getName().length()<3) throw new ProductValidationException("Name must be longer than 3");
        if(product.getName().length()>25) throw new ProductValidationException("Name must be shorter than 25");
        if(repository.existbyName(product.getName())) throw new ProductValidationException("Name already exist");
    }
}

