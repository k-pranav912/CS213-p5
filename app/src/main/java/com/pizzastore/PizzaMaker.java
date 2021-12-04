package com.pizzastore;

/**
 * Class that creates a flavored pizza based on a string describing the flavor
 */
public class PizzaMaker {
    /**
     * Creates the appropriate pizza based on the flavor string
     * @param flavor Type of pizza desired
     * @return Newly created flavored pizza object
     */
    public static Pizza createPizza(String flavor) {
        switch (flavor) {
            case "Pepperoni":
                return new Pepperoni();
            case "Hawaiian":
                return new Hawaiian();
            case "Deluxe":
                return new Deluxe();
            default:
                return null;
        }
    }
}
