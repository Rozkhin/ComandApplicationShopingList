package com.company.shoppinglist.Database.product;


import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

@Component
public class ProductCollection {
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

    public int getsize() {
        return productRepository.size();
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

    public void deleteProductById(Long id){
        productRepository.remove(id);
    }
}
