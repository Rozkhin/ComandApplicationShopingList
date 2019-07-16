package com.company.shoppinglist.Database.product;

import com.company.shoppinglist.Database.product.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Cart {

    private long id;

    String name;

    String description;

    //public Cart(String name, String description) {
    //  this.name = name;
    //    this.description = description;
    //}

    Map<Long, Product> InCartproductRepository = new HashMap<>();
    private Long productIdSequence = 0L;

    public Product insert(Product product) {
        product.setId(productIdSequence);
        InCartproductRepository.put(productIdSequence, product);
        productIdSequence++;
        return product;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList getAllids() {
        ArrayList<Product> PrdList = new ArrayList<>();
        for (Map.Entry<Long, Product> n : InCartproductRepository.entrySet()) {
            Product Cprd = n.getValue();
            PrdList.add(Cprd);
        }
        return PrdList;
    }

    public void deleteproduct(Long id) {
         InCartproductRepository.remove(id);
    }


    public void setDescription(String description) {
        this.description = description;
    }

    public Map<Long, Product> GetRepository(){
        return InCartproductRepository;
    }
}