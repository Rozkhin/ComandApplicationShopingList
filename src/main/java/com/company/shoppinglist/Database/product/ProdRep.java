package com.company.shoppinglist.Database.product;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
@Component
public interface ProdRep {

    public Product insert(Product product);

    public Product findProductById(Long id);

    public Product findCardById(Long id);

    public List<Long> getallids();

    public boolean existbyName(String productName) ;

    public void insert(Cart cart);

    public Cart Getcart(Long id);

    public Map<Long, Cart> getAllcarts();

    public void delete(Long id);
}
