package com.company.shoppinglist.Service;

import com.company.shoppinglist.Database.product.Collection;
import com.company.shoppinglist.Database.product.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    Collection repository = new Collection();
    private ProductValidationService validationService = new ProductValidationService();

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
}
