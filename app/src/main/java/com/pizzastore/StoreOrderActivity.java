package com.pizzastore;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;

public class StoreOrderActivity extends AppCompatActivity implements Serializable {

    private StoreOrders store;

    private EditText storeOrderDisplay;
    private Spinner storeOrderSpinner;
    private Button removeOrderButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store_orders);

        store = (StoreOrders) getIntent().getSerializableExtra("STORE_ORDERS");

        storeOrderDisplay = findViewById(R.id.storeOrderDisplay);
        storeOrderSpinner = findViewById(R.id.storeOrderSpinner);
        removeOrderButton = findViewById(R.id.removeOrderButton);

        storeOrderDisplay.setText(store.toString());

        ArrayAdapter<Order> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, store.getList());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        storeOrderSpinner.setAdapter(adapter);


    }
}
