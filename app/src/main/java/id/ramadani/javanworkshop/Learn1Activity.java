package id.ramadani.javanworkshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Learn1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn1);

        ImageView imgBromo = (ImageView) findViewById(R.id.img_bromo);
        imgBromo.setImageResource(R.drawable.bromo_milky_way);
        imgBromo.setAdjustViewBounds(true);
        imgBromo.setScaleType(ImageView.ScaleType.FIT_START);

        TextView tvBromo = (TextView) findViewById(R.id.tv_bromo);
        tvBromo.setText("Bromo Mountain");
    }
}
