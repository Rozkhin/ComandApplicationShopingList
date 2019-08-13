package com.company.shoppinglist.Database.product;


import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




public class ProductCollection implements ProdRep {
    Map<Long, Product> productRepository = new HashMap<>();
    private Long productIdSequence = 0L;

    public Product insert(Product product) {
        product.setId(productIdSequence);
        productRepository.put(productIdSequence, product);
        productIdSequence++;
        return product;
    }

    public Product findProductById(Long id) {
        return productRepository.get(id);
    }

    @Override
    public Product findCardById(Long id) {
        return null;
    }

    public List<Long> getallids() {
        ArrayList<Long> idlist = new ArrayList<>();
        for (Map.Entry<Long, Product> n : productRepository.entrySet()) {
            Long id = n.getKey();
            idlist.add(id);
        }
        return idlist;
    }

    public boolean existbyName(String productName) {
        return productRepository.values().stream().anyMatch(s -> s.getName().equals(productName));
    }

    @Override
    public void insert(Cart cart) {

    }

    @Override
    public Cart Getcart(Long id) {
        return null;
    }

    @Override
    public Map<Long, Cart> getAllcarts() {
        return null;
    }

    @Override
    public void delete(Long id) {
        productRepository.remove(id);
    }
}
