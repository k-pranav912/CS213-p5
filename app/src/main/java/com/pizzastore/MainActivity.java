package com.pizzastore;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import  androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.material.textfield.TextInputEditText;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements Serializable {

    private static StoreOrders store;
    private static Order currentOrder;

    private TextInputEditText s0PhoneTextField;

    /**
     * Initializes the savedInstanceState, UI, the user's store order, and
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.store = new StoreOrders();
        s0PhoneTextField = findViewById(R.id.s0PhoneTextField);
    }

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

    public void checkStoreOrders(View view) {
        Intent intent = new Intent(this, StoreOrderActivity.class);
        intent.putExtra("STORE_ORDERS", store);
        startActivity(intent);
    }

    public static void addPizza(Pizza pizza) {
        currentOrder.add(pizza);
        System.out.println(currentOrder);
    }

    public static void addOrder(Order order) {
        store.add(order);
        currentOrder = null;
    }

    public static Order getCurrentOrder() {
        return currentOrder;
    }

    public static StoreOrders getStore() {
        return store;
    }

}