/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommercesystem;

import static java.lang.Math.abs;

/**
 *
 * @author Mina
 */
public class Cart {
private int customerId;
    private int nProducts;
    private Product[] products;
  

    public Cart(int customerId) {
        this.customerId = Math.abs(customerId);
        this.nProducts = 0;
        this.products = new Product[10]; // Assuming a maximum of 10 products for simplicity
    }

    
    
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = Math.abs(customerId);
    }

    public int getnProducts() {
        return nProducts;
    }

    public void addProduct(Product product) {
        if (nProducts < products.length) {
            products[nProducts++] = product;
        } else {
            System.out.println("Cart is full!");
        }
    }

    public void removeProduct(int productId) {
        for (int i = 0; i < nProducts; i++) {
            if (products[i].getProductId() == productId) {
                for (int j = i; j < nProducts - 1; j++) {
                    products[j] = products[j + 1];
                }
                nProducts--;
                break;
            }
        }
    }

    public double calculatePrice() {
        double totalPrice = 0;
        for (int i = 0; i < nProducts; i++) {
            totalPrice += products[i].getPrice();
        }
        return totalPrice;
    }

    public Order placeOrder() {
        return new Order(customerId, products, calculatePrice());
    }
}
  


