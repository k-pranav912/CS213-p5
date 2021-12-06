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

public class OrderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, Serializable {

    private EditText orderDisplay;
    private TextInputEditText subtotalText;
    private TextInputEditText salesTaxText;
    private TextInputEditText totalText;
    private Spinner spinner;
    private ArrayAdapter<Pizza> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.current_order);

        orderDisplay = findViewById(R.id.orderDisplay);
        subtotalText = findViewById(R.id.subtotal);
        salesTaxText = findViewById(R.id.salestax);
        totalText = findViewById(R.id.total);
        spinner = findViewById(R.id.spinner);

        orderDisplay.setText(MainActivity.getCurrentOrder().toString());
        subtotalText.setText(MainActivity.getCurrentOrder().getSubTotal() + "");
        salesTaxText.setText(MainActivity.getCurrentOrder().getSalesTax() + "");
        totalText.setText(MainActivity.getCurrentOrder().getTotal() + "");

        adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, MainActivity.getCurrentOrder().getList());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

    }

    public void removePizza(View view) {
        Pizza pizza = (Pizza) spinner.getSelectedItem();
        MainActivity.getCurrentOrder().remove(pizza);
        adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, MainActivity.getCurrentOrder().getList());
        spinner.setAdapter(adapter);
        orderDisplay.getText().clear();
        orderDisplay.setText(MainActivity.getCurrentOrder().toString());
        System.out.println(MainActivity.getCurrentOrder().toString());
        if (MainActivity.getCurrentOrder().getList().size() == 0) {
            finish();
        }
    }

    public void placeOrder(View view) {
        MainActivity.addOrder(MainActivity.getCurrentOrder());
        finish();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}