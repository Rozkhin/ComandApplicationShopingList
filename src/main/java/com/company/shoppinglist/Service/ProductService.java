package com.company.shoppinglist.Service;

import com.company.shoppinglist.Database.product.ProdRep;
import com.company.shoppinglist.Database.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class ProductService {

    ProdRep repository;
    ProductValidationService validationService;
@Autowired
    public ProductService(ProdRep repository, ProductValidationService validationService) {
        this.repository = repository;
        this.validationService=validationService;
    }

    public Long createProduct(Product product){
        boolean result =validationService.validate(product);
        if(result) {
            Product createdProduct = repository.insert(product);
            return createdProduct.getId();
        }
        return null;
    }

    public Product findProductById(Long id){
        Product product;
        product=repository.findProductById(id);
        return product;
    }

    public ArrayList<Long> GetAllProduct(){
        List<Long> productIDlist=new ArrayList();
        productIDlist = repository.getallids();
        return (ArrayList<Long>) productIDlist;
    }

    public void deleteproduct(Long id){
    repository.delete(id);
    }
}
