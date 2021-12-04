package com.pizzastore;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import  androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private StoreOrders store;
    private Order currentOrder;

    private TextInputEditText s0PhoneTextField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.store = new StoreOrders();
        s0PhoneTextField = findViewById(R.id.s0PhoneTextField);
    }

    public void setOrderNull() { this.currentOrder = null; }

    public void startNewOrder(View view) throws NumberFormatException {
        currentOrder = null;
        Context context = getApplicationContext();
        String temp = s0PhoneTextField.getText().toString();
        long phoneNumber = 0;
        if (temp.equals(""))
            Toast.makeText(context, "Enter Valid Phone Number (Numbers Only)", Toast.LENGTH_LONG).show();

        try {
            phoneNumber = Long.parseLong(temp);
        } catch (NumberFormatException e) {
            Toast.makeText(context, "Enter Valid Phone Number (Numbers Only)", Toast.LENGTH_LONG).show();
            return;
        }

        if (phoneNumber < 0) {
            Toast.makeText(context, "Enter Valid Phone Number (Numbers Only)", Toast.LENGTH_LONG).show();
            return;
        }

        this.currentOrder = new Order(phoneNumber);
        Toast.makeText(context, "Order " + phoneNumber + " started.", Toast.LENGTH_LONG).show();

        if (store.checkOrder(this.currentOrder)) {
            Toast.makeText(context, "Order " + phoneNumber + " already exists.", Toast.LENGTH_LONG).show();
            currentOrder = null;
            return;
        }
    }

    public void addPepperoni(View view) {
        Intent intent = new Intent(this, PizzaActivity.class);
        intent.putExtra("FLAVOR", "Pepperoni");
        intent.putExtra("CURRENT_ORDER", currentOrder);
        startActivity(intent);
    }

    public void addHawaiian(View view) {
        Intent intent = new Intent(this, PizzaActivity.class);
        intent.putExtra("FLAVOR", "Hawaiian");
        intent.putExtra("CURRENT_ORDER", currentOrder);
        startActivity(intent);
    }

    public void addDeluxe(View view) {
        Intent intent = new Intent(this, PizzaActivity.class);
        intent.putExtra("FLAVOR", "Deluxe");
        intent.putExtra("CURRENT_ORDER", currentOrder);
        startActivity(intent);
    }

    public void checkCurrentOrder(View view) {
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
}