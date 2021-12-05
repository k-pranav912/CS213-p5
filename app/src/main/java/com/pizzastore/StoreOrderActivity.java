package com.pizzastore;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;

public class StoreOrderActivity extends AppCompatActivity implements Serializable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store_orders);
    }
}
