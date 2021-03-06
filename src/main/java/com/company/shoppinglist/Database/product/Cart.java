package com.company.shoppinglist.Database.product;

import com.company.shoppinglist.Database.product.Product;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "Cart")

public class Cart {


    @Id
    @Column(name ="id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;
    @Column(name = "cartName")
    private String name;
    @Column(name = "cartDescription")
    private String description;
    @ManyToMany(fetch = FetchType.EAGER)
    List<Product> InCartproductRepository = new ArrayList<>();

    public Product insert(Product product) {
        InCartproductRepository.add(product);
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
        return (ArrayList) InCartproductRepository;
    }

    public void deleteproduct(int id) {
         InCartproductRepository.remove(id);
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Product> GetRepository(){
        return (ArrayList<Product>) InCartproductRepository;
    }
}