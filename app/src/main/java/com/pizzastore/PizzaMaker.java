package com.pizzastore;

import java.io.Serializable;

/**
 * Class that creates a flavored pizza based on a string describing the flavor
 * @authors Neel Prabhu, Saipranav Kalapala
 */
public class PizzaMaker implements Serializable {
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
