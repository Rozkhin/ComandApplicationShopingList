package com.company.shoppinglist.Database.product;

import java.util.List;

public interface Collection {

    public Product insert(Product product);

    public Product findProductById(Long id);

    public List<Long> getallids();

    public boolean existbyName(String productName) ;
}
