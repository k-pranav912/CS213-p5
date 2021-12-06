package com.pizzastore;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputEditText;

import java.io.Serializable;
import java.text.DecimalFormat;

/**
 * Pizza Activity class, which handles the pizza customization activity
 * @authors Neel Prabhu, Saipranav Kalapala
 */
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

    /**
     * Initializes the UI, title, pizza, toppings, and image based on the flavor of pizza. Links the views.
     * @param savedInstanceState Saved instance of previous app loads
     */
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

    /**
     * Sets the image at the top of the UI based on the flavor of pizza
     */
    private void setImage() {
        s1ImageView.setImageResource(pizza.getImageID());
    }

    /**
     * Deselects all checkboxes, then selects the ones which are preset by the pizza
     */
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

    /**
     * Adds the topping to the pizza if applicable
     * @param checkBox Checkbox to be deselected if it exceeds max toppings
     * @param topping Topping to be added
     */
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

    /**
     * On checking pepperoni, add the topping. On unchecking pepperoni, remove the topping. Re-calculate price
     * @param view View the user interacted with, Pepperoni Checkbox
     */
    public void pepperoniClick(View view) {
        if (pepperoniCheck.isChecked()) {
            addTopping(pepperoniCheck, Topping.PEPPERONI);
        }
        else {
            pizza.toppings.remove(Topping.PEPPERONI);
        }
        s1PriceTextField.setText(df.format(this.pizza.price()) + "");
    }

    /**
     * On checking pineapple, add the topping. On unchecking pineapple, remove the topping. Re-calculate price
     * @param view View the user interacted with, Pineapple Checkbox
     */
    public void pineappleClick(View view) {
        if (pineappleCheck.isChecked()) {
            addTopping(pineappleCheck, Topping.PINEAPPLE);
        }
        else {
            pizza.toppings.remove(Topping.PINEAPPLE);
        }
        s1PriceTextField.setText(df.format(this.pizza.price()) + "");
    }

    /**
     * On checking chicken, add the topping. On unchecking chicken, remove the topping. Re-calculate price
     * @param view View the user interacted with, Chicken Checkbox
     */
    public void chickenClick(View view) {
        if (chickenCheck.isChecked()) {
            addTopping(chickenCheck, Topping.CHICKEN);
        }
        else {
            pizza.toppings.remove(Topping.CHICKEN);
        }
        s1PriceTextField.setText(df.format(this.pizza.price()) + "");
    }

    /**
     * On checking ham, add the topping. On unchecking ham, remove the topping. Re-calculate price
     * @param view View the user interacted with, Ham Checkbox
     */
    public void hamClick(View view) {
        if (hamCheck.isChecked()) {
            addTopping(hamCheck, Topping.HAM);
        }
        else {
            pizza.toppings.remove(Topping.HAM);
        }
        s1PriceTextField.setText(df.format(this.pizza.price()) + "");
    }

    /**
     * On checking beef, add the topping. On unchecking beef, remove the topping. Re-calculate price
     * @param view View the user interacted with, Beef Checkbox
     */
    public void beefClick(View view) {
        if (beefCheck.isChecked()) {
            addTopping(beefCheck, Topping.BEEF);
        }
        else {
            pizza.toppings.remove(Topping.BEEF);
        }
        s1PriceTextField.setText(df.format(this.pizza.price()) + "");
    }

    /**
     * On checking olives, add the topping. On unchecking olives, remove the topping. Re-calculate price
     * @param view View the user interacted with, Olives Checkbox
     */
    public void olivesClick(View view) {
        if (olivesCheck.isChecked()) {
            addTopping(olivesCheck, Topping.OLIVES);
        }
        else {
            pizza.toppings.remove(Topping.OLIVES);
        }
        s1PriceTextField.setText(df.format(this.pizza.price()) + "");
    }

    /**
     * On checking extra cheese, add the topping. On unchecking extra cheese, remove the topping. Re-calculate price
     * @param view View the user interacted with, Extra Cheese Checkbox
     */
    public void extraCheeseClick(View view) {
        if (extraCheeseCheck.isChecked()) {
            addTopping(extraCheeseCheck, Topping.EXTRA_CHEESE);
        }
        else {
            pizza.toppings.remove(Topping.EXTRA_CHEESE);
        }
        s1PriceTextField.setText(df.format(this.pizza.price()) + "");
    }

    /**
     * On checking green pepper, add the topping. On unchecking green pepper, remove the topping. Re-calculate price
     * @param view View the user interacted with, Green Pepper Checkbox
     */
    public void greenPepperClick(View view) {
        if (greenPepperCheck.isChecked()) {
            addTopping(greenPepperCheck, Topping.GREEN_PEPPER);
        }
        else {
            pizza.toppings.remove(Topping.GREEN_PEPPER);
        }
        s1PriceTextField.setText(df.format(this.pizza.price()) + "");
    }

    /**
     * On checking onion, add the topping. On unchecking onion, remove the topping. Re-calculate price
     * @param view View the user interacted with, Onion Checkbox
     */
    public void onionClick(View view) {
        if (onionCheck.isChecked()) {
            addTopping(onionCheck, Topping.ONION);
        }
        else {
            pizza.toppings.remove(Topping.ONION);
        }
        s1PriceTextField.setText(df.format(this.pizza.price()) + "");
    }

    /**
     * Sets the pizza size to small and recalculates price
     * @param view View the user interacted with, Small Radiobutton
     */
    public void selectSmall(View view) {
        pizza.setSize(Size.SMALL);
        s1PriceTextField.setText(df.format(this.pizza.price()) + "");
    }

    /**
     * Sets the pizza size to medium and recalculates price
     * @param view View the user interacted with, Medium Radiobutton
     */
    public void selectMedium(View view) {
        pizza.setSize(Size.MEDIUM);
        s1PriceTextField.setText(df.format(this.pizza.price()) + "");
    }

    /**
     * Sets the pizza size to Large and recalculates price
     * @param view View the user interacted with, Large Radiobutton
     */
    public void selectLarge(View view) {
        pizza.setSize(Size.LARGE);
        s1PriceTextField.setText(df.format(this.pizza.price()) + "");
    }

    /**
     * Adds the pizza to the current order and finishes the activity.
     * @param view View the user interacted with, Add to Order Button
     */
    public void addToOrder(View view) {
        MainActivity.addPizza(pizza);
        finish();
    }

}
