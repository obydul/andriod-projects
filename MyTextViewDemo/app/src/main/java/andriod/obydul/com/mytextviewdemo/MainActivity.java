package andriod.obydul.com.mytextviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private TextView nameTextView, ageTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameTextView = (TextView) findViewById(R.id.nameTextViewId);
        nameTextView.setText("Bilkes Jahan");
        ageTextView = (TextView) findViewById(R.id.ageTextViewId);
        ageTextView.setText("30");
    }
}
