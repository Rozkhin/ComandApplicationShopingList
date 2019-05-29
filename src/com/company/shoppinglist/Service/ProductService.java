package com.company.shoppinglist.Service;

import com.company.shoppinglist.Database.product.Collection;
import com.company.shoppinglist.Database.product.Product;

import java.util.ArrayList;

public class ProductService {
    Collection repository = new Collection();
    private ProductValidationService validationService = new ProductValidationService();

    public Long createProduct(Product product){
        boolean result =validationService.validate(product);
        Long id=null;
        if(result) {
            Product createdProduct = repository.insert(product);
            id=createdProduct.getId();
        }
        return id;
    }

    public Product findProductById(Long id){
        Product product;
        product=repository.findProductById(id);
        return product;
    }

    public ArrayList<Product> GetAllProduct(){
        ArrayList productlist=new ArrayList();
        for (int i=0;i==repository.getsize();i++){
            Product product=repository.findProductById(Long.valueOf(i));
            productlist.add(product);
        }
        return productlist;
    }
}
