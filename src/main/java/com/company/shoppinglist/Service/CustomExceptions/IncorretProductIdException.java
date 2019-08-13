package com.company.shoppinglist.Service.CustomExceptions;

public class IncorretProductIdException extends RuntimeException {
    public IncorretProductIdException(String errorMsg) {
        super(errorMsg);
    }
}
