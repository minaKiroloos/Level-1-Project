package ecommercesystem;


import ecommercesystem.Product;
import static java.lang.Math.abs;

class Order {
    private int customerId;
    private int orderId;
    private Product[] products;
    private double totalPrice;
    public int orderdProducts;
    public Order(int customerId, Product[] products, double totalPrice) {
        this.customerId = Math.abs(customerId);
        this.orderId = (int) (Math.random() * 1000); // Generating a random order ID for simplicity
        this.products = products;
        this.totalPrice = totalPrice;
    }

    
    public void setOrderdProducts(int orderdProducts) {
        this.orderdProducts = abs(orderdProducts);
    }

    public void printOrderInfo() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer ID: " + customerId);
        System.out.println("Products:");
        for (int i = 0;i<orderdProducts;i++) {
          System.out.println(products[i].getName()+ " - " + products[i].getPrice());
        }
        System.out.println("Total Price: $" + totalPrice);
    }
}