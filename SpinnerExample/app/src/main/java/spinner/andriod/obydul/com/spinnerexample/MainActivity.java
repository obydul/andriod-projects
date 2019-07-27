package spinner.andriod.obydul.com.spinnerexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String[] countryNames;
    private Spinner spinner;
    private Button button;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countryNames = getResources().getStringArray(R.array.country_name);

        spinner = findViewById(R.id.spinnerId);
        button = findViewById(R.id.btnPrint);
        textView = findViewById(R.id.textViewId);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, R.layout.sample_view, R.id.txtSample, countryNames);
        spinner.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = spinner.getSelectedItem().toString();
                textView.setText(value);
            }
        });

    }
}
