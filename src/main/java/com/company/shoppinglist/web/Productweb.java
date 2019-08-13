package com.company.shoppinglist.web;



import com.company.shoppinglist.Database.product.Product;
import com.company.shoppinglist.Database.product.ProductTypes;
import com.company.shoppinglist.Service.CustomExceptions.IncorretProductIdException;
import com.company.shoppinglist.Service.ProductService;
import com.company.shoppinglist.Service.ProductValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

@RestController
@RequestMapping("/api_v1/products/")
public class Productweb {

    private ProductService productService;

    public Productweb(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id) {

        return productService.findProductById(id);
    }

    @GetMapping
    public ArrayList<Long> getAllProducts() {

        return productService.GetAllProduct();
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody ProductDTO productDTO) {

        Product prod = ProductConverter.convert(productDTO);
        productService.createProduct(prod);
        System.out.println(prod.toString());
        return ResponseEntity.ok(prod);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable("id") Long id) {

        productService.deleteproduct(id);
    }


    @RequestMapping(value = "/prdtest", method = RequestMethod.POST)
    public Product test(@RequestBody Map<String, String> body) {
        Product product = new Product();
        product.setName(body.get("name"));
        product.setDescription(body.get("description"));
        product.setType(ProductTypes.MILK);
        System.out.println(product.toString());
        return product;
    }

    @ExceptionHandler(IncorretProductIdException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleIncorretProductIdException(IncorretProductIdException e) {
         }

    @ExceptionHandler(ProductValidationException.class)
    public ResponseEntity<String> handleProductValidationException(ProductValidationException e) {
                return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
    }
}
