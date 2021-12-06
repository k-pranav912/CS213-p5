package com.pizzastore;

import java.io.Serializable;

/**
 * Enumerated class for the pizza sizes: small, medium, or large
 * @authors Neel Prabhu, Saipranav Kalapala
 */
public enum Size implements Serializable {
    SMALL, MEDIUM, LARGE;

    /**
     * Converts Size to string description
     * @return String describing its size
     */
    @Override
    public String toString() {
        switch (this) {
            case SMALL:
                return "Small";
            case MEDIUM:
                return "Medium";
            case LARGE:
                return "Large";
            default:
                return "";
        }
    }
}


