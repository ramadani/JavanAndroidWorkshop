package id.ramadani.javanworkshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class BirthdayCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthday_card);
        setTitle(R.string.happy_birthday);
    }
}
