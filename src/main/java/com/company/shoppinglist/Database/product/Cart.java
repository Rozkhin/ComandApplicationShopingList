package com.company.shoppinglist.Database.product;

import com.company.shoppinglist.Database.product.Product;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "Cart")
public class Cart {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    String name;

    @Column(name = "description")
    String description;

    @JoinColumn(name = "id")
    @OneToMany

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