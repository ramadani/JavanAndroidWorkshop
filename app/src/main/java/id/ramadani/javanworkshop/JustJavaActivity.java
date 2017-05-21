package id.ramadani.javanworkshop;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.name;

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
        if (quantity == 100) {
            Toast.makeText(this, "You cannot have more than 100 coffees", Toast.LENGTH_SHORT)
                    .show();

            return;
        }

        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    public void decrement(View view) {
        if (quantity <= 1) {
            Toast.makeText(this, "You cannot have less than 1 coffee", Toast.LENGTH_SHORT).show();

            return;
        }

        quantity = quantity - 1;
        displayQuantity(quantity);
    }

    public void submitOrder(View view) {
        EditText etName = (EditText) findViewById(R.id.tv_name);
        String name = etName.getText().toString();

        CheckBox cbWhippedCream = (CheckBox) findViewById(R.id.cb_whipped_cream);
        boolean hasWhippedCream = cbWhippedCream.isChecked();

        CheckBox cbChocolate = (CheckBox) findViewById(R.id.cb_chocolate);
        boolean hasChocolate = cbChocolate.isChecked();

        int price = calculatePrice(hasWhippedCream, hasChocolate);
        String orderSummary = createOrderSummary(name, price, hasWhippedCream, hasChocolate);

        sendTo(orderSummary);
    }

    private void displayQuantity(int numberOfCoffees) {
        TextView tvQuantity = (TextView) findViewById(R.id.tv_quantity);
        tvQuantity.setText(String.valueOf(numberOfCoffees));
    }

    private int calculatePrice(boolean addWhippedCream, boolean addChocolate) {
        int basePrice = 5;

        if (addWhippedCream) {
            basePrice += 1;
        }

        if (addChocolate) {
            basePrice += 2;
        }

        return basePrice * quantity;
    }

    /**
     * Create summary of the order
     * @param name name of the order
     * @param price price of the order
     * @param addWhippedCream is whether or not the user wants whipped cream topping
     * @param addChocolate is whether or not the user wants chocolate topping
     * @return text summary
     */
    private String createOrderSummary(String name, int price, boolean addWhippedCream,
                                      boolean addChocolate) {
        String orderSummary = getString(R.string.order_summary_name, name)
                + "\nAdd Whipped Cream? " + addWhippedCream
                + "\nAdd Chocolate? " + addChocolate
                + "\nQuantity: " + quantity
                + "\nTotal: $" + price;

        return orderSummary + "\n" + getString(R.string.thank_you);
    }

    private void sendTo(String text) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java order for " + name);
        intent.putExtra(Intent.EXTRA_TEXT, text);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
