package com.pizzastore;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class OrderActivity extends AppCompatActivity {

    private Order currentOrder;
    private StoreOrders store;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.current_order);

        currentOrder = (Order) getIntent().getSerializableExtra("CURRENT_ORDER");
        store = (StoreOrders) getIntent().getSerializableExtra("STORE_ORDERS");


    }
}