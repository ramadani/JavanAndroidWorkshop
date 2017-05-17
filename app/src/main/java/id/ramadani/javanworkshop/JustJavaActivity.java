package id.ramadani.javanworkshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class JustJavaActivity extends AppCompatActivity {
    int quantity = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_just_java);
        setTitle(R.string.just_java);
        display(quantity);
    }

    public void submitOrder(View view) {
        int quantity = 5;
        display(quantity);
        displayPrice(quantity * 5);
    }

    public void increment(View view) {
        quantity = quantity + 1;
        display(quantity);
    }

    public void decrement(View view) {
        quantity = quantity - 1;
        display(quantity);
    }

    private void display(int number) {
        TextView tvQuantity = (TextView) findViewById(R.id.tv_quantity);
        tvQuantity.setText(String.valueOf(number));
    }

    private void displayPrice(int number) {
        TextView tvPrice = (TextView) findViewById(R.id.tv_price);
        tvPrice.setText(NumberFormat.getCurrencyInstance().format(number));
    }
}
