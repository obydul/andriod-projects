package andriod.obydul.com.intentdatapassing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        textView = findViewById(R.id.txtSecond);

        Bundle bundle = getIntent().getExtras();
        if (bundle!=null){
            //String value = bundle.getString("tag");
            String value = bundle.getString("edtValue");
            textView.setText(value);
        }
    }
}
