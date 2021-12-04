package com.pizzastore;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Order class, which contains a list of pizzas and a unique phone number identifier
 */
public class Order implements Serializable {
    private long phoneNumber;
    private ArrayList<Pizza> pizzas = new ArrayList<Pizza>();
    private static final double SALES_TAX = .06625;

    /**
     * Constructor that sets the order's unique phone number
     * @param phoneNumber
     */
    public Order(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Adds a pizza to the order
     * @param pizza Pizza to be added
     */
    public void add(Pizza pizza) {
        pizzas.add(pizza);
    }

    /**
     * Removes a pizza from the order
     * @param pizza Pizza to be removed
     */
    public void remove(Pizza pizza) {
        pizzas.remove(pizza);
    }

    /**
     * Calculates the subtotal of the order
     * @return Subtotal price
     */
    public double getSubTotal() {
        double subTotal = 0;
        for (int i = 0; i < pizzas.size(); i++) {
            subTotal += pizzas.get(i).price();
        }
        return subTotal;
    }

    /**
     * Calculates the sales tax amount of the order
     * @return Sales tax price
     */
    public double getSalesTax() {
        return this.getSubTotal() * SALES_TAX;
    }

    /**
     * Calculates the total price of the order
     * @return Total price
     */
    public double getTotal() {
        return this.getSubTotal() + this.getSalesTax();
    }

    /**
     * Gets the order's unique phone number
     * @return Phone number of the order
     */
    public long getPhoneNumber() {
        return this.phoneNumber;
    }

    /**
     * Gets the list of pizzas
     * @return Arraylist of pizzas
     */
    public ArrayList<Pizza> getList() {
        return this.pizzas;
    }

    /**
     * Converts the order into a string with its unique phone number and list of pizzas
     * @return String describing the order
     */
    @Override
    public String toString() {
        String orderString = "Phone #: " + phoneNumber + "\n";
        for (int i = 0; i < pizzas.size(); i++) {
            orderString += (i + 1) + ". " + pizzas.get(i).toString();
        }
        return orderString;
    }
}
