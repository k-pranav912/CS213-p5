package com.pizzastore;

import java.io.Serializable;
import java.util.ArrayList;
import java.text.DecimalFormat;

/**
 * StoreOrders class, which contains a list of orders the user placed.
 */
public class StoreOrders implements Serializable {
    ArrayList<Order> orders;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    /**
     * Constructor that initializes the list of orders
     */
    public StoreOrders() {
         orders = new ArrayList<Order>();
    }

    /**
     * Iterates through the orders to see if the order already exists
     * @param order Order to be searched for
     * @return True if found, false if not
     */
    public boolean checkOrder(Order order) {
        for (Order x: orders) {
            if (x.getPhoneNumber() == order.getPhoneNumber()) return true;
        }
        return false;
    }

    /**
     * Adds a placed order to the store orders
     * @param order Order to be added
     */
    public void add(Order order) {
        orders.add(order);
    }

    /**
     * Removes a placed order from the store orders
     * @param order Order to be removed
     */
    public void remove(Order order) {
        orders.remove(order);
    }

    /**
     * Calculates the subtotal amount of all placed orders
     * @return Subtotal price
     */
    private double calculateSubtotal() {
        double subTotal = 0;
        for (Order x: orders) {
            subTotal += x.getSubTotal();
        }
        return subTotal;
    }

    /**
     * Calculates the sales tax amount of all placed orders
     * @return Sales tax price
     */
    private double calculateSalesTax() {
        double salesTax = 0;
        for (Order x: orders) {
            salesTax += x.getSalesTax();
        }
        return salesTax;
    }

    /**
     * Calculates the total amount of all placed orders
     * @return Total price
     */
    public double calculateTotal() {
        return this.calculateSalesTax() + this.calculateSubtotal();
    }

    /**
     * Converts all placed orders into a string, divided by asterisks.
     * @return String describing all store orders
     */
    @Override
    public String toString() {
        if (orders.size() < 1) return "";
        String storeOrdersString = "*************************************\n";
        for (int i = 0; i < orders.size(); i++) {
            storeOrdersString += orders.get(i).toString() + "Price of Order: $"
                                                + df.format(orders.get(i).getTotal()) +"\n";
            storeOrdersString += "*************************************\n";
        }
        return storeOrdersString;
    }
}
