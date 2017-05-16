package id.ramadani.javanworkshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class JustJavaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_just_java);
        setTitle(R.string.just_java);
    }

    public void submitOrder(View view) {
        display(2);
        displayPrice(2 * 5);
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
