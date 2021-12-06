package com.pizzastore;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import  androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.material.textfield.TextInputEditText;

import java.io.IOException;
import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements Serializable {

    private static StoreOrders store;
    private static Order currentOrder;

    private TextInputEditText s0PhoneTextField;

    /**
     * Initializes the UI and the user's store order, and links the views
     * @param savedInstanceState Saved instance of previous app loads
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.store = new StoreOrders();
        s0PhoneTextField = findViewById(R.id.s0PhoneTextField);
    }

    /**
     * Initializes an order based on the user entered phone number, if it is not already on order or invalid
     * @param view View the user interacted with, Start Order button
     * @throws NumberFormatException If the Phone Number was not a valid integer
     */
    public void startNewOrder(View view) throws NumberFormatException {
        System.out.println(currentOrder);
        currentOrder = null;
        Context context = getApplicationContext();
        String temp = s0PhoneTextField.getText().toString();
        long phoneNumber = 0;

        if (temp.equals(""))
            Toast.makeText(context, "Enter Valid Phone Number (Numbers Only)", Toast.LENGTH_SHORT).show();

        try {
            phoneNumber = Long.parseLong(temp);
        } catch (NumberFormatException e) {
            Toast.makeText(context, "Enter Valid Phone Number (Numbers Only)", Toast.LENGTH_SHORT).show();
            return;
        }

        if (phoneNumber < 0) {
            Toast.makeText(context, "Enter Valid Phone Number (Numbers Only)", Toast.LENGTH_SHORT).show();
            return;
        }

        this.currentOrder = new Order(phoneNumber);

        if (store.checkOrder(this.currentOrder)) {
            Toast.makeText(context, "Order " + phoneNumber + " already exists.", Toast.LENGTH_SHORT).show();
            currentOrder = null;
            return;
        }
        Toast.makeText(context, "Order " + phoneNumber + " started.", Toast.LENGTH_SHORT).show();
    }

    /**
     * Goes to the Pizza Customization activity to add a pepperoni pizza in the user entered Order (if it exists) Passes
     * data via intent.
     * @param view View the user interacted with, Pepperoni button
     */
    public void addPepperoni(View view) {
        if (this.currentOrder == null) {
            Toast.makeText(getApplicationContext(), "Please create an order first.", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent(this, PizzaActivity.class);
        intent.putExtra("FLAVOR", "Pepperoni");
        intent.putExtra("CURRENT_ORDER", currentOrder);
        startActivity(intent);
    }

    /**
     * Goes to the Pizza Customization activity to add a hawaiian pizza in the user entered Order (if it exists). Passes
     * data via intent.
     * @param view View the user interacted with, Hawaiian button
     */
    public void addHawaiian(View view) {
        if (this.currentOrder == null) {
            Toast.makeText(getApplicationContext(), "Please create an order first.", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent(this, PizzaActivity.class);
        intent.putExtra("FLAVOR", "Hawaiian");
        intent.putExtra("CURRENT_ORDER", currentOrder);
        startActivity(intent);
    }

    /**
     * Goes to the Pizza Customization activity to add a deluxe pizza in the user entered Order (if it exists). Passes
     * data via intent
     * @param view View the user interacted with, Deluxe button
     */
    public void addDeluxe(View view) {
        if (this.currentOrder == null) {
            Toast.makeText(getApplicationContext(), "Please create an order first.", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent(this, PizzaActivity.class);
        intent.putExtra("FLAVOR", "Deluxe");
        intent.putExtra("CURRENT_ORDER", currentOrder);
        startActivity(intent);
    }

    /**
     * Goes to the Current Order activity for the user to review their order (if it exists) and place it if need be.
     * Passes data via intent.
     * @param view View the user interacted with, Check Current Order button
     */
    public void checkCurrentOrder(View view) {
        if (this.currentOrder == null) {
            Toast.makeText(getApplicationContext(), "Please create an order first.", Toast.LENGTH_SHORT).show();
            return;
        }
        if (this.currentOrder.getList().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Empty Order.", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent(this, OrderActivity.class);
        intent.putExtra("CURRENT_ORDER", currentOrder);
        intent.putExtra("STORE_ORDERS", store);
        startActivity(intent);
    }

    /**
     * Goes to the Store Order activity for the user to review their orders and delete them if need be.
     * Passes data via intent.
     * @param view View the user interacted with, Check Store Orders button
     */
    public void checkStoreOrders(View view) {
        Intent intent = new Intent(this, StoreOrderActivity.class);
        intent.putExtra("STORE_ORDERS", store);
        startActivity(intent);
    }

    /**
     * Static method to add a pizza to the current order
     * @param pizza Pizza to be added
     */
    public static void addPizza(Pizza pizza) {
        currentOrder.add(pizza);
    }

    /**
     * Static method to add an order to the store orders
     * @param order Order to be added
     */
    public static void addOrder(Order order) {
        store.add(order);
        currentOrder = null;
    }

    /**
     * Gets the current order
     * @return Current order
     */
    public static Order getCurrentOrder() {
        return currentOrder;
    }

    /**
     * Gets the store orders
     * @return Store orders
     */
    public static StoreOrders getStore() {
        return store;
    }

}