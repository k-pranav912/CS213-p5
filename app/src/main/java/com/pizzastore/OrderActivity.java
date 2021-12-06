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
import java.text.DecimalFormat;

/**
 * OrderActivity class, handles the activity view for the Current Order page.
 * @authors Neel Prabhu, Saipranav Kalapala
 */
public class OrderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, Serializable {

    private EditText orderDisplay;
    private TextInputEditText subtotalText;
    private TextInputEditText salesTaxText;
    private TextInputEditText totalText;
    private Spinner spinner;
    private ArrayAdapter<Pizza> adapter;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    /**
     * Constructor method, called when view is initiated.
     * @param savedInstanceState saved instance of view, used if app is reloaded.
     */
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
        setPrices();

        adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, MainActivity.getCurrentOrder().getList());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

    }

    /**
     * sets prices on display for each field: subtotal, sales tax, total price.
     */
    private void setPrices() {
        subtotalText.setText(df.format(MainActivity.getCurrentOrder().getSubTotal()) + "");
        salesTaxText.setText(df.format(MainActivity.getCurrentOrder().getSalesTax()) + "");
        totalText.setText(df.format(MainActivity.getCurrentOrder().getTotal()) + "");
    }

    /**
     * Removes pizza from the store's current order.
     * @param view Button view
     */
    public void removePizza(View view) {
        Pizza pizza = (Pizza) spinner.getSelectedItem();
        MainActivity.getCurrentOrder().remove(pizza);
        adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, MainActivity.getCurrentOrder().getList());
        spinner.setAdapter(adapter);
        orderDisplay.getText().clear();
        orderDisplay.setText(MainActivity.getCurrentOrder().toString());
        setPrices();
        if (MainActivity.getCurrentOrder().getList().size() == 0) {
            finish();
        }
    }

    /**
     * Finalizes and adds the store's current order to the store order page.
     * @param view Button view
     */
    public void placeOrder(View view) {
        MainActivity.addOrder(MainActivity.getCurrentOrder());
        finish();
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