package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends ActionBarActivity {

    int Quantity=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */

    public void submitOrder(View view) {


        int amt=Quantity*5;
        EditText name=(EditText)findViewById(R.id.name);
        String priceMsg="Name "+name.getText().toString();
        CheckBox ckCream=(CheckBox)findViewById(R.id.ckCream);
        if(ckCream.isChecked())
        {
            amt+=1*Quantity;
        priceMsg+="\n Please Add Whipped Cream ";
        }
        CheckBox ckChoco=(CheckBox)findViewById(R.id.ckChoco);
        if(ckChoco.isChecked())
        {
            amt+=2*Quantity;
            priceMsg+="\n Please Add chocolate  ";
        }

        priceMsg+=" \n Amount Due $"+(amt)+" \nThank you";
        displayMessage(priceMsg);
    }
    private void displayMessage(String msg){
        TextView price=(TextView)findViewById(R.id.textprice);
        price.setText(msg);
    }
    public void increment(View view){

        Quantity=Quantity+1;
        display(Quantity);
        //displayPrice(Quantity*5);

    }

    public void decrement(View view){

        Quantity=Quantity-1;
        display(Quantity);
        //displayPrice(Quantity*5);

    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.textquant);
        quantityTextView.setText("" + number);
    }

    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.textprice);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
}