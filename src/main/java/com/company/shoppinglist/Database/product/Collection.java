package com.company.shoppinglist.Database.product;

import java.util.List;
import java.util.Map;

public interface Collection {

    public Product insert(Product product);

    public Product findProductById(Long id);

    public Product findCardById(Long id);

    public List<Long> getallids();

    public boolean existbyName(String productName) ;

    public void insert(Cart cart);

    public Cart Getcart(Long id);

    public Map<Long, Cart> getAllcarts();
}
