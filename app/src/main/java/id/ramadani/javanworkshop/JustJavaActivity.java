package id.ramadani.javanworkshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class JustJavaActivity extends AppCompatActivity {
    private final static String LOG_TAG = JustJavaActivity.class.getSimpleName();

    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_just_java);
        setTitle(R.string.just_java);
        displayQuantity(quantity);
    }

    public void increment(View view) {
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    public void decrement(View view) {
        quantity = quantity - 1;
        displayQuantity(quantity);
    }

    public void submitOrder(View view) {
        CheckBox cbWhippedCream = (CheckBox) findViewById(R.id.cb_whipped_cream);
        boolean hasWhippedCream = cbWhippedCream.isChecked();

        CheckBox cbChocolate = (CheckBox) findViewById(R.id.cb_chocolate);
        boolean hasChocolate = cbChocolate.isChecked();

        int price = calculatePrice(quantity);
        String priceMessage = createOrderSummary("Ramadani", price, hasWhippedCream,
                hasChocolate);
        displayMessage(priceMessage);
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

    /**
     * Create summary of the order
     * @param fullName fullName of the order
     * @param price price of the order
     * @param addWhippedCream is whether or not the user wants whipped cream topping
     * @param addChocolate is whether or not the user wants chocolate topping
     * @return text summary
     */
    private String createOrderSummary(String fullName, int price, boolean addWhippedCream,
                                      boolean addChocolate) {
        String orderSummary = "Name: " + fullName
                + "\nAdd Whipped Cream? " + addWhippedCream
                + "\nAdd Chocolate? " + addChocolate
                + "\nQuantity: " + quantity
                + "\nTotal: $" + price;

        return orderSummary + "\nThank you!";
    }
}
