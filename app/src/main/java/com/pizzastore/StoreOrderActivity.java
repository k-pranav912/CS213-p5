package com.pizzastore;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;

/**
 * StoreOrderActivity class, handles the activity view for the Store Orders page
 * @authors Neel Prabhu, Saipranav Kalapala
 */

public class StoreOrderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, Serializable {


    private EditText storeOrderDisplay;
    private Spinner storeOrderSpinner;
    private Button removeOrderButton;
    private ArrayAdapter<Order> adapter;

    /**
     * Constructor method, called when view is initiated.
     * sets up on-screen data.
     * @param savedInstanceState saved instance of view, used if app is reloaded.
     */
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

    /**
     * removes order from the store.
     * @param view Button view
     */
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

    /**
     *  Implement abstract method needed for spinner.
     * @param parent parent AdapterView instance
     * @param view View
     * @param position position in the Adapter
     * @param id
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    }

    /**
     * Implement abstract method needed for spinner.
     * @param parent parent AdapterView
     */
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}
