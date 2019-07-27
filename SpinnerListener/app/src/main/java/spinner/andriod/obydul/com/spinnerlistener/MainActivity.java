package spinner.andriod.obydul.com.spinnerlistener;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String[] countryNames;
    private String[] population;
    int[] flags = {R.drawable.afganistan_flag,
            R.drawable.armenia_flag,
            R.drawable.azerbijan_flag,
            R.drawable.bahrain_flag,
            R.drawable.bangladesh_flag,
            R.drawable.bhutan_flag,
            R.drawable.china_flag,
            R.drawable.japan_flag,
            R.drawable.maldives_flag,
            R.drawable.pakistan_flag,
            R.drawable.turkey_flag,
            R.drawable.iran_flag
    };

    private Spinner spinner;
    private Button button;
    private TextView textView;
    private boolean isFirstSelection = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countryNames = getResources().getStringArray(R.array.country_name);
        population = getResources().getStringArray(R.array.population);

        spinner = findViewById(R.id.spinnerId);
        button = findViewById(R.id.btnShow);
        textView = findViewById(R.id.txtShow);

        CustomAdapter customAdapter = new CustomAdapter(MainActivity.this, flags,countryNames, population);

        spinner.setAdapter(customAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (isFirstSelection==true){
                    isFirstSelection=false;
                } else {
                    Toast.makeText(getApplicationContext(), countryNames[position] + " is selected ", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
