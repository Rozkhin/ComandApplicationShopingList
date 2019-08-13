package com.company.shoppinglist.Service.CustomExceptions;

public class IncorretShoppingCartProductIdException extends RuntimeException {
    public IncorretShoppingCartProductIdException(String errorMsg) { super(errorMsg);
    }
}
