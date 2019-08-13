package com.company.shoppinglist.web;

import com.company.shoppinglist.Database.product.Cart;
import com.company.shoppinglist.Database.product.Product;
import com.company.shoppinglist.Service.CartService;
import com.company.shoppinglist.Service.CustomExceptions.IncorretProductIdException;
import com.company.shoppinglist.Service.CustomExceptions.IncorretShoppingCartIdException;
import com.company.shoppinglist.Service.CustomExceptions.IncorretShoppingCartProductIdException;
import com.company.shoppinglist.Service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api_v1/shoppingcarts/")
public class ShoppingCartweb {
    private CartService shoppingCartService;
    private ProductService productService;

    public ShoppingCartweb(CartService shoppingCartService, ProductService productService) {
        this.shoppingCartService = shoppingCartService;
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getShoppingCartById(@PathVariable("id") Long shoppingCartId) {
        ObjectMapper objectMapper = new ObjectMapper();
        ShoppingCartDTO shoppingCartDTO = ShoppingCartConverter.convert(shoppingCartService.loadCart(shoppingCartId);
        String jsonString = "";

        try {
            jsonString = objectMapper.writeValueAsString(shoppingCartDTO);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(jsonString);
    }

    @GetMapping
    public List<ShoppingCartDTO> getAllShoppingCarts() {
        List<Cart> shoppingCarts = (List<Cart>) shoppingCartService.getallcardsfromrep();
        List<ShoppingCartDTO> shoppingCartDTOS = new ArrayList<>();

        shoppingCarts.forEach(shoppingCart -> shoppingCartDTOS.add(ShoppingCartConverter.convert(shoppingCart)));
        return shoppingCartDTOS;
    }

    @PostMapping
    public ResponseEntity<Void> createShoppingCarts(@Validated({ShoppingCartDTO.Create.class}) @RequestBody ShoppingCartDTO shoppingCartDTO, UriComponentsBuilder uriComponentsBuilder) {
        Cart shoppingCart = ShoppingCartConverter.convert(shoppingCartDTO);
        Long id;
        id = shoppingCartService.Newcart(shoppingCart.getName(),shoppingCart.getDescription());
        return ResponseEntity.created(uriComponentsBuilder.path("/api_v1/shoppingcarts/{id}").buildAndExpand(id).toUri()).build();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteShoppingCarts(@PathVariable Long id) {
        shoppingCartService.deletecart(id);
    }

    @ExceptionHandler(IncorretShoppingCartIdException.class)
    public ResponseEntity<String> handleIncorretShoppingCartIdException(IncorretShoppingCartIdException e) {
        return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IncorretShoppingCartProductIdException.class)
    public ResponseEntity<String> handleIncorretShoppingCartProductIdException(IncorretShoppingCartProductIdException e) {
        return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IncorretProductIdException.class)
    public ResponseEntity<String> handleIncorretProductIdException(IncorretProductIdException e) {
        return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    //@PostMapping(value = "/{id}/products", params = "product_id")
    //@ResponseStatus(HttpStatus.OK)
    // void addProductbyIdToShoppingCart(@PathVariable("id") Long shoppingCartId, @RequestParam("product_id") Long productId) {
   //     shoppingCartService.(productService.findProductById(productId));
    //}

    @DeleteMapping(value = "/{id}/products", params = "product_id")
    @ResponseStatus(HttpStatus.OK)
    public void deleteProductByIdFromShoppingCart(@PathVariable("id") Long shoppingCartId, @RequestParam("product_id") Long productId) {
        Product product = productService.findProductById(productId);
        shoppingCartService.deleteProductFromCurrentCart(Math.toIntExact(productId));
    }

    @GetMapping("/{id}/products")
    public ResponseEntity<List<Product>> getShoppingCartProducts(@PathVariable("id") Long shoppingCartId) {
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(shoppingCartService.getCurrentCartProducts());
    }
}
