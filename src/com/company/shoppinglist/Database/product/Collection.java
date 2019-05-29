package com.company.shoppinglist.Database.product;

import java.util.HashMap;
import java.util.Map;

public  class Collection
{
    Map<Long, Product> productRepository = new HashMap<>();
    private Long productIdSequence = 0L;

    public Product insert(Product product){
        product.setId(productIdSequence);
        productRepository.put(productIdSequence,product);
        productIdSequence++;
        return product;
    }

    public Product findProductById(Long id){
        return productRepository.get(id);
    }

    public int getsize(){return productRepository.size();}
}
