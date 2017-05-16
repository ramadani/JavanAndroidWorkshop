package id.ramadani.javanworkshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class JustJavaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_just_java);
        setTitle(R.string.just_java);
    }

    public void submitOrder(View view) {
        display(1);
    }

    private void display(int number) {
        TextView tvQuantity = (TextView) findViewById(R.id.tv_quantity);
        tvQuantity.setText("" + number);
    }
}
