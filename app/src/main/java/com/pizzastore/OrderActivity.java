package com.pizzastore;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.EditText;
import com.google.android.material.textfield.TextInputEditText;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class OrderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, Serializable {

    private Order currentOrder;
    private StoreOrders store;

    private EditText orderDisplay;
    private TextInputEditText subtotalText;
    private TextInputEditText salesTaxText;
    private TextInputEditText totalText;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.current_order);

        currentOrder = (Order) getIntent().getSerializableExtra("CURRENT_ORDER");
        store = (StoreOrders) getIntent().getSerializableExtra("STORE_ORDERS");

        orderDisplay = findViewById(R.id.orderDisplay);
        subtotalText = findViewById(R.id.subtotal);
        salesTaxText = findViewById(R.id.salestax);
        totalText = findViewById(R.id.total);
        spinner = findViewById(R.id.spinner);

        orderDisplay.setText(currentOrder.toString());
        subtotalText.setText(currentOrder.getSubTotal() + "");
        salesTaxText.setText(currentOrder.getSalesTax() + "");
        totalText.setText(currentOrder.getTotal() + "");

        ArrayList<String> arr = new ArrayList<>(Arrays.asList("abcd", "efgh", "ijkl", "mnop"));
        System.out.println(currentOrder);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, arr);
        //ArrayAdapter<Pizza> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, currentOrder.getList());
        //ArrayAdapter<Pizza> adapter = ArrayAdapter.createFromResource(this, currentOrder.getList(), android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

    }

    public void removePizza(View view) {

    }

    public void placeOrder(View view) {

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}