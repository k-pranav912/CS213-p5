package com.pizzastore;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.EditText;
import com.google.android.material.textfield.TextInputEditText;

public class OrderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

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