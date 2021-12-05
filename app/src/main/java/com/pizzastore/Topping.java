package com.pizzastore;

import java.io.Serializable;

/**
 * Enumerated class for the 11 available toppings
 */
public enum Topping implements Serializable {
    PEPPERONI, PINEAPPLE, CHICKEN, BEEF, HAM, OLIVES, EXTRA_CHEESE, GREEN_PEPPER, ONION;

    /**
     * Converts Topping into string equivalent
     * @return String describing the topping
     */
    @Override
    public String toString() {
        switch (this) {
            case PEPPERONI:
                return "Pepperoni";
            case PINEAPPLE:
                return "Pineapple";
            case EXTRA_CHEESE:
                return "Extra Cheese";
            case HAM:
                return "Ham";
            case BEEF:
                return "Beef";
            case ONION:
                return "Onion";
            case OLIVES:
                return "Olives";
            case CHICKEN:
                return "Chicken";
            case GREEN_PEPPER:
                return "Green Pepper";
            default:
                return "";
        }
    }
}
