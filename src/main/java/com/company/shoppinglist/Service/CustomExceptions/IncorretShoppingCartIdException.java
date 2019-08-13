package com.company.shoppinglist.Service.CustomExceptions;

public class IncorretShoppingCartIdException extends RuntimeException {
    public IncorretShoppingCartIdException(String errorMsg) {
        super(errorMsg);
    }
}
