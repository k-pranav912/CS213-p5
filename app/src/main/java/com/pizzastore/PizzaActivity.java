package com.pizzastore;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputEditText;

import java.io.Serializable;
import java.text.DecimalFormat;

public class PizzaActivity extends AppCompatActivity implements Serializable {
    private Pizza pizza;
    private static final DecimalFormat df = new DecimalFormat("0.00");

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

        setTitle(getIntent().getStringExtra("FLAVOR"));

        s1PriceTextField = findViewById(R.id.s1PriceTextField);
        s1ImageView = findViewById(R.id.s1ImageView);
        pepperoniCheck = findViewById(R.id.pepperoniCheck);
        pineappleCheck = findViewById(R.id.pineappleCheck);
        chickenCheck = findViewById(R.id.chickenCheck);
        hamCheck = findViewById(R.id.hamCheck);
        beefCheck = findViewById(R.id.beefCheck);
        olivesCheck = findViewById(R.id.oliveCheck);
        extraCheeseCheck = findViewById(R.id.extraCheeseCheck);
        greenPepperCheck = findViewById(R.id.greenPepperCheck);
        onionCheck = findViewById(R.id.onionCheck);

        s1PriceTextField.setText(df.format(this.pizza.price()) + "");
        setImage();
        selectPresets();
    }

    private void setImage() {
        s1ImageView.setImageResource(pizza.getImageID());
    }

    private void selectPresets() {
        pepperoniCheck.setChecked(false);
        pineappleCheck.setChecked(false);
        chickenCheck.setChecked(false);
        hamCheck.setChecked(false);
        beefCheck.setChecked(false);
        olivesCheck.setChecked(false);
        extraCheeseCheck.setChecked(false);
        greenPepperCheck.setChecked(false);
        onionCheck.setChecked(false);

        for (Topping x: pizza.toppings) {
            switch (x) {
                case PEPPERONI:
                    pepperoniCheck.setChecked(true);
                    break;
                case PINEAPPLE:
                    pineappleCheck.setChecked(true);
                    break;
                case CHICKEN:
                    chickenCheck.setChecked(true);
                    break;
                case HAM:
                    hamCheck.setChecked(true);
                    break;
                case BEEF:
                    beefCheck.setChecked(true);
                    break;
                case OLIVES:
                    olivesCheck.setChecked(true);
                    break;
                case EXTRA_CHEESE:
                    extraCheeseCheck.setChecked(true);
                    break;
                case GREEN_PEPPER:
                    greenPepperCheck.setChecked(true);
                    break;
                case ONION:
                    onionCheck.setChecked(true);
                    break;
            }
        }
    }

    private void addTopping(CheckBox checkBox, Topping topping) {
        if (pizza.toppings.size() >= Pizza.MAX_TOPPINGS) {
            Context context = getApplicationContext();
            Toast.makeText(context, "Maximum of " + Pizza.MAX_TOPPINGS + " toppings allowed!", Toast.LENGTH_SHORT).show();
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
        s1PriceTextField.setText(df.format(this.pizza.price()) + "");
    }

    public void pineappleClick(View view) {
        if (pineappleCheck.isChecked()) {
            addTopping(pineappleCheck, Topping.PINEAPPLE);
        }
        else {
            pizza.toppings.remove(Topping.PINEAPPLE);
        }
        s1PriceTextField.setText(df.format(this.pizza.price()) + "");
    }

    public void chickenClick(View view) {
        if (chickenCheck.isChecked()) {
            addTopping(chickenCheck, Topping.CHICKEN);
        }
        else {
            pizza.toppings.remove(Topping.CHICKEN);
        }
        s1PriceTextField.setText(df.format(this.pizza.price()) + "");
    }

    public void hamClick(View view) {
        if (hamCheck.isChecked()) {
            addTopping(hamCheck, Topping.HAM);
        }
        else {
            pizza.toppings.remove(Topping.HAM);
        }
        s1PriceTextField.setText(df.format(this.pizza.price()) + "");
    }

    public void beefClick(View view) {
        if (beefCheck.isChecked()) {
            addTopping(beefCheck, Topping.BEEF);
        }
        else {
            pizza.toppings.remove(Topping.BEEF);
        }
        s1PriceTextField.setText(df.format(this.pizza.price()) + "");
    }

    public void olivesClick(View view) {
        if (olivesCheck.isChecked()) {
            addTopping(olivesCheck, Topping.OLIVES);
        }
        else {
            pizza.toppings.remove(Topping.OLIVES);
        }
        s1PriceTextField.setText(df.format(this.pizza.price()) + "");
    }

    public void extraCheeseClick(View view) {
        if (extraCheeseCheck.isChecked()) {
            addTopping(extraCheeseCheck, Topping.EXTRA_CHEESE);
        }
        else {
            pizza.toppings.remove(Topping.EXTRA_CHEESE);
        }
        s1PriceTextField.setText(df.format(this.pizza.price()) + "");
    }

    public void greenPepperClick(View view) {
        if (greenPepperCheck.isChecked()) {
            addTopping(greenPepperCheck, Topping.GREEN_PEPPER);
        }
        else {
            pizza.toppings.remove(Topping.GREEN_PEPPER);
        }
        s1PriceTextField.setText(df.format(this.pizza.price()) + "");
    }

    public void onionClick(View view) {
        if (onionCheck.isChecked()) {
            addTopping(onionCheck, Topping.ONION);
        }
        else {
            pizza.toppings.remove(Topping.ONION);
        }
        s1PriceTextField.setText(df.format(this.pizza.price()) + "");
    }

    public void selectSmall(View view) {
        pizza.setSize(Size.SMALL);
        s1PriceTextField.setText(df.format(this.pizza.price()) + "");
    }

    public void selectMedium(View view) {
        pizza.setSize(Size.MEDIUM);
        s1PriceTextField.setText(df.format(this.pizza.price()) + "");
    }

    public void selectLarge(View view) {
        pizza.setSize(Size.LARGE);
        s1PriceTextField.setText(df.format(this.pizza.price()) + "");
    }

    public void addToOrder(View view) {
        //currentOrder.add(pizza);
        //System.out.println(currentOrder);
        MainActivity.addPizza(pizza);
        finish();
    }

}
