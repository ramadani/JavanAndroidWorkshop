package id.ramadani.javanworkshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class JustJavaActivity extends AppCompatActivity {
    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_just_java);
        setTitle(R.string.just_java);
        displayQuantity(quantity);
    }

    public void submitOrder(View view) {
        int price = calculatePrice(quantity);
        String priceMessage = createOrderSummary("Ramadani", price);
        displayMessage(priceMessage);
    }

    public void increment(View view) {
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    public void decrement(View view) {
        quantity = quantity - 1;
        displayQuantity(quantity);
    }

    private void displayQuantity(int numberOfCoffees) {
        TextView tvQuantity = (TextView) findViewById(R.id.tv_quantity);
        tvQuantity.setText(String.valueOf(numberOfCoffees));
    }

    private void displayMessage(String message) {
        TextView tvOrderSummary = (TextView) findViewById(R.id.tv_order_summary);
        tvOrderSummary.setText(message);
    }

    private int calculatePrice(int quantity) {
        int price = quantity * 5;
        return price;
    }

    private String createOrderSummary(String fullName, int price) {
        String orderSummary = "Name: " + fullName
                + "\nQuantity: " + quantity
                + "\nTotal: $" + price;

        return orderSummary + "\nThank you!";
    }
}
