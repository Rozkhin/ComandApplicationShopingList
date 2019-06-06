package com.company.shoppinglist.GUI;

import com.company.shoppinglist.Database.product.Product;
import com.company.shoppinglist.Database.product.ProductTypes;
import com.company.shoppinglist.Service.ProductService;


import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class ConsoleI {
    private ProductService productService = new ProductService();

    public void execute() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("1. Create product");
                System.out.println("2. Show information about product by id");
                System.out.println("3. Change product description ");
                System.out.println("4. Exit");
                Integer userInput = Integer.valueOf(scanner.nextLine());
                switch (userInput) {
                    case 1:
                        CreateProduct();
                        break;
                    case 2:
                        FindProducById();
                        break;
                    case 3:
                        changeProductDescription();
                        break;
                    case 4:
                        return;
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error! Please try again");
            }
        }
    }

    private void CreateProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product name: ");
        String name = scanner.nextLine();
        System.out.println("Enter product price: ");
        BigDecimal price = new BigDecimal(scanner.nextLine());
        System.out.println("Enter product discount: ");
        BigDecimal discount = new BigDecimal(scanner.nextLine());
        System.out.println("Enter product category: ");
        ProductTypes Type;
        do {
            for (ProductTypes pt : ProductTypes.values()) {
                System.out.println(pt.ordinal() + ". " + pt.toString());
            }
            int userInput = Integer.valueOf(scanner.nextLine());
            Type = ProductTypes.getProductById(userInput);
            if (Type == null) {
                System.out.println("no such product type");
            }
        } while (Type == null);
        System.out.println("Enter product description: ");
        String description = scanner.nextLine();
        Product prd = new Product();
        prd.setName(name);
        prd.setPrice(price);
        prd.setDiscount(discount);
        prd.setType(Type);
        prd.setDescription(description);
        Long id = productService.createProduct(prd);
        if (id == null) System.out.println("Can't create product");

    }

   public static void printProduct(Product p) {
        System.out.println(p.getId() + " | "
                + p.getName() + " | "
                + p.getPrice() + " | "
                + p.getType().toString() + " | "
                + p.getDiscount() + " | "
                + p.getActualPrice() + " | "
                + p.getDescription());
    }

    private void FindProducById() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Enter Id to find product by id number: ");
        System.out.println("2. Show all products: ");
        System.out.println("3. Exit ");
        Integer userInput = Integer.valueOf(scanner.nextLine());
        switch (userInput) {
            case 1:
                System.out.println("Enter id: ");
                Product prd = productService.findProductById(scanner.nextLong());
                if(prd==null){
                    System.out.println("no such id");
                }else
                    printProduct(prd);
                break;
            case 2:
                ArrayList<Long> Idlist;
                Idlist=productService.GetAllProduct();
                for (Long id:Idlist){
                    Product prd1=productService.findProductById(id);
                    printProduct(prd1);
                }
        }
    }

    private void changeProductDescription() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter id of product to change the description");
        Product prd = productService.findProductById(Long.valueOf(scanner.nextLine()));
        if(prd!=null){
            System.out.println("Current description is: "+prd.getDescription());
            System.out.println("Enter product description: ");
            String description = String.valueOf(scanner.nextLine());
            prd.setDescription(description);

        }

    }
}
