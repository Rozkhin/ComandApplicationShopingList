package com.company.shoppinglist.Service.CustomExceptions;

public class ProductValidationException extends RuntimeException {
    public ProductValidationException(String errMsg) {
        super(errMsg);
    }
}
