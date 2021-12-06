package com.pizzastore;

import java.io.Serializable;

/**
 * Class of Deluxe flavored pizza, which contains its own price and toString() implementation
 * @authors Neel Prabhu, Saipranav Kalapala
 */
public class Deluxe extends Pizza implements Serializable {
    private static final double SMALL_PRICE = 12.99;
    private static final int MIN_TOPPINGS = 5;
    private static final int IMAGE_ID = R.drawable.deluxe;

    /**
     * Constructor to initialize a Deluxe object, sets default size as small and adds the default toppings
     */
    public Deluxe() {
        toppings.add(Topping.PINEAPPLE);
        toppings.add(Topping.HAM);
        toppings.add(Topping.GREEN_PEPPER);
        toppings.add(Topping.ONION);
        toppings.add(Topping.CHICKEN);
        size = Size.SMALL;
    }

    /**
     * Calculates the price of the Deluxe pizza based on its toppings and size
     * @return The pizzas price as a double
     */
    public double price() {
        double sizePrice = 0;
        switch (size) {
            case SMALL:
                sizePrice = SMALL_PRICE;
                break;
            case MEDIUM:
                sizePrice = SMALL_PRICE + SIZE_INCREASE_PRICE;
                break;
            case LARGE:
                sizePrice = SMALL_PRICE + SIZE_INCREASE_PRICE + SIZE_INCREASE_PRICE;
                break;
        }
        int temp = toppings.size() - MIN_TOPPINGS;
        if (temp < 0) temp = 0;
        return sizePrice + (temp) * TOPPING_PRICE;
    }

    /**
     * Converts a pizza to a string that gives its flavor (Deluxe), size, and list of toppings
     * @return String describing the pizza
     */
    @Override
    public String toString() {
        String pizzaString = "Deluxe Pizza - " + size.toString() + "\n";
        pizzaString += this.toppingsString();
        return pizzaString;
    }

    /**
     * Method to get the path to the image of the pizza
     * @return String path to pizza image
     */
    public int getImageID() {
        return IMAGE_ID;
    }
}
