package com.pizzastore;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Abstract class that all flavors of pizza inherit. Contains common methods, instance variables and
 * three abstract methods, toString(), getImagePath(), and price().
 * @authors Neel Prabhu, Saipranav Kalapala
 */
public abstract class Pizza implements Serializable {
    protected ArrayList<Topping> toppings = new ArrayList<Topping>();
    protected Size size;

    protected static final double SIZE_INCREASE_PRICE = 2;
    protected static final double TOPPING_PRICE = 1.49;
    protected static final int MAX_TOPPINGS = 7;

    /**
     * Abstract method that will calculate the price of a pizza based on its flavor, size, and toppings
     * @return Price of the pizza
     */
    public abstract double price();

    /**
     * Sets the size of the pizza
     * @param newSize New size of the pizza
     */
    public void setSize(Size newSize) {
        size = newSize;
    }

    /**
     * Abstract toString() method, for each flavor to implement.
     * @return String describing Pizza and its Size/Toppings
     */
    @Override
    public abstract String toString();

    /**
     * Gives a string of all toppings on the pizza, indented and in a list
     * @return String of toppings
     */
    public String toppingsString() {
        String toppingString = "";
        for (int i = 0; i < toppings.size(); i++) {
            toppingString += "\t-" + toppings.get(i) + "\n";
        }
        return toppingString;
    }

    /**
     * Gets the maximum number of toppings
     * @return Maximum toppings int
     */
    public int getMaxToppings() {
        return this.MAX_TOPPINGS;
    }

    /**
     * Abstract method to get the path to the image of the pizza
     * @return String path to pizza image
     */
    public abstract int getImageID();
}
