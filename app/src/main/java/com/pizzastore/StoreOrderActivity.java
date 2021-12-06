package com.pizzastore;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;

public class StoreOrderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, Serializable {


    private EditText storeOrderDisplay;
    private Spinner storeOrderSpinner;
    private Button removeOrderButton;
    private ArrayAdapter<Order> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store_orders);

        storeOrderDisplay = findViewById(R.id.storeOrderDisplay);
        storeOrderSpinner = findViewById(R.id.storeOrderSpinner);
        removeOrderButton = findViewById(R.id.removeOrderButton);

        storeOrderDisplay.setText(MainActivity.getStore().toString());

        adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, MainActivity.getStore().getList());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        storeOrderSpinner.setAdapter(adapter);


    }

    public void removeOrder(View view) {
        Order order = (Order) storeOrderSpinner.getSelectedItem();
        MainActivity.getStore().remove(order);
        adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, MainActivity.getStore().getList());
        storeOrderSpinner.setAdapter(adapter);
        storeOrderDisplay.setText(MainActivity.getStore().toString());
        if (MainActivity.getStore().getList().size() == 0) {
            finish();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}
