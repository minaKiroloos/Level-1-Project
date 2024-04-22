/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommercesystem;

import java.util.Scanner;

/**
 *
 * @author Mina
 */
public class EcommerceSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
          ElectronicProduct electronicProduct = new ElectronicProduct();
        electronicProduct.setProductId(1);
        electronicProduct.setName("smartphone");
        electronicProduct.setPrice(599.9);
        electronicProduct.setBrand("Samsung");
        electronicProduct.setWarrantyPeriod(1);

        // Create clothing product
        ClothingProduct clothingProduct = new ClothingProduct();
        clothingProduct.setProductId(2);
        clothingProduct.setName("T-shirt");
        clothingProduct.setPrice(19.99);
        clothingProduct.setSize("Medium");
        clothingProduct.setFabric("Cotton");

        // Create book product
        BookProduct bookProduct = new BookProduct();
        bookProduct.setProductId(3);
        bookProduct.setName("OOP");
        bookProduct.setPrice(39.99);
        bookProduct.setAuthor("O’Reilly");
        bookProduct.setPublisher("X Publications");

        // Create customer
        System.out.println("Enter your customer ID:");
        int customerId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("Enter your name:");
        String name = scanner.nextLine();
        System.out.println("Enter your address:");
        String address = scanner.nextLine();
        Customer customer = new Customer();
        customer.setCustomerId(customerId);
        customer.setName(name);
        customer.setAddress(address);

        // Create shopping cart
        Cart cart = new Cart(customer.getCustomerId());
        
        // Add products to the cart
        System.out.println("How many products do you want to order?");
        int numProducts = scanner.nextInt();
        scanner.nextLine(); 
        
        
        
        
        for (int i = 0; i < numProducts; i++) {
            System.out.println("Which product would you like to add? 1-Smartphone 2-T-shirt 3-OOP");
            String productType = scanner.nextLine();
            switch (productType.toLowerCase()) {
                case "1":
                    cart.addProduct(electronicProduct);
                    break;
                case "2":
                    cart.addProduct(clothingProduct);
                    break;
                case "3":
                    cart.addProduct(bookProduct);
                    break;
                default:
                    System.out.println("Invalid product type!");
            }
        }

       
        System.out.println("Your total is =$"+cart.calculatePrice()+" Do you want to place an order for the products in the cart? 1-Yes 2-No");
        int response = scanner.nextInt();
        if (response==1) {
            Order order = cart.placeOrder();
            order.printOrderInfo();
            order.setOrderdProducts(numProducts);
        } else {
            System.out.println("Order not placed.");
        }

    }
}