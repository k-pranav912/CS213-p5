package com.pizzastore;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputEditText;

import java.text.DecimalFormat;

public class PizzaActivity extends AppCompatActivity {
    private Pizza pizza;
    private static final DecimalFormat df = new DecimalFormat("0.00");
    private Order currentOrder;

    private TextInputEditText s1PriceTextField;
    private ImageView s1ImageView;
    private CheckBox pepperoniCheck;
    private CheckBox pineappleCheck;
    private CheckBox chickenCheck;
    private CheckBox hamCheck;
    private CheckBox beefCheck;
    private CheckBox olivesCheck;
    private CheckBox extraCheeseCheck;
    private CheckBox greenPepperCheck;
    private CheckBox onionCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pizza_customization);
        this.pizza = PizzaMaker.createPizza(getIntent().getStringExtra("FLAVOR"));
        s1PriceTextField.setText(this.pizza.price() + "");
        s1ImageView.setImageResource(0); //UNSURE WHAT NUMBER CORRESPONDS TO WHAT
        selectPresets();
        currentOrder = (Order) getIntent().getSerializableExtra("CURRENT_ORDER");
        //NEED TO CHANGE APP NAME
    }

    private void selectPresets() {
        for (Topping x: pizza.toppings) {
            switch (x) {
                case PEPPERONI: pepperoniCheck.setChecked(true);
                case PINEAPPLE: pineappleCheck.setChecked(true);
                case CHICKEN: chickenCheck.setChecked(true);
                case HAM: hamCheck.setChecked(true);
                case BEEF: beefCheck.setChecked(true);
                case OLIVES: olivesCheck.setChecked(true);
                case EXTRA_CHEESE: extraCheeseCheck.setChecked(true);
                case GREEN_PEPPER: greenPepperCheck.setChecked(true);
                case ONION: onionCheck.setChecked(true);
            }
        }
    }

    private void addTopping(CheckBox checkBox, Topping topping) {
        if (pizza.toppings.size() >= Pizza.MAX_TOPPINGS) {
            Context context = getApplicationContext();
            Toast.makeText(context, "Maximum of " + Pizza.MAX_TOPPINGS + " allowed!", Toast.LENGTH_LONG).show();
            checkBox.setChecked(false);
        }
        else {
            pizza.toppings.add(topping);
        }
    }
    public void pepperoniClick(View view) {
        if (pepperoniCheck.isChecked()) {
            addTopping(pepperoniCheck, Topping.PEPPERONI);
        }
        else {
            pizza.toppings.remove(Topping.PEPPERONI);
        }
        s1PriceTextField.setText(this.pizza.price() + "");
    }

    public void pineappleClick(View view) {
        if (pineappleCheck.isChecked()) {
            addTopping(pineappleCheck, Topping.PINEAPPLE);
        }
        else {
            pizza.toppings.remove(Topping.PINEAPPLE);
        }
        s1PriceTextField.setText(this.pizza.price() + "");
    }

    public void chickenClick(View view) {
        if (chickenCheck.isChecked()) {
            addTopping(chickenCheck, Topping.CHICKEN);
        }
        else {
            pizza.toppings.remove(Topping.CHICKEN);
        }
        s1PriceTextField.setText(this.pizza.price() + "");
    }

    public void hamClick(View view) {
        if (hamCheck.isChecked()) {
            addTopping(hamCheck, Topping.HAM);
        }
        else {
            pizza.toppings.remove(Topping.HAM);
        }
        s1PriceTextField.setText(this.pizza.price() + "");
    }

    public void beefClick(View view) {
        if (beefCheck.isChecked()) {
            addTopping(beefCheck, Topping.BEEF);
        }
        else {
            pizza.toppings.remove(Topping.BEEF);
        }
        s1PriceTextField.setText(this.pizza.price() + "");
    }

    public void olivesClick(View view) {
        if (olivesCheck.isChecked()) {
            addTopping(olivesCheck, Topping.OLIVES);
        }
        else {
            pizza.toppings.remove(Topping.OLIVES);
        }
        s1PriceTextField.setText(this.pizza.price() + "");
    }

    public void extraCheeseClick(View view) {
        if (extraCheeseCheck.isChecked()) {
            addTopping(extraCheeseCheck, Topping.EXTRA_CHEESE);
        }
        else {
            pizza.toppings.remove(Topping.EXTRA_CHEESE);
        }
        s1PriceTextField.setText(this.pizza.price() + "");
    }

    public void greenPepperClick(View view) {
        if (greenPepperCheck.isChecked()) {
            addTopping(greenPepperCheck, Topping.GREEN_PEPPER);
        }
        else {
            pizza.toppings.remove(Topping.GREEN_PEPPER);
        }
        s1PriceTextField.setText(this.pizza.price() + "");
    }

    public void onionClick(View view) {
        if (onionCheck.isChecked()) {
            addTopping(onionCheck, Topping.ONION);
        }
        else {
            pizza.toppings.remove(Topping.ONION);
        }
        s1PriceTextField.setText(this.pizza.price() + "");
    }

    public void selectSmall(View view) {
        this.pizza.setSize(Size.SMALL);
        s1PriceTextField.setText(df.format(this.pizza.price()) + "");
    }

    public void selectMedium(View view) {
        this.pizza.setSize(Size.MEDIUM);
        s1PriceTextField.setText(df.format(this.pizza.price()) + "");
    }

    public void selectLarge(View view) {
        this.pizza.setSize(Size.LARGE);
        s1PriceTextField.setText(df.format(this.pizza.price()) + "");
    }

    public void addToOrder(View view) {
        currentOrder.add(pizza);
        finish();
    }

}
