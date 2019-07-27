package andriod.obydul.com.spinnerdemo01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner;
    private String[] countryNames;
    private String[] population;
    private int[] flags = {
            R.drawable.afganistan_flag,
            R.drawable.armenia_flag,
            R.drawable.azerbijan_flag,
            R.drawable.bahrain_flag,
            R.drawable.bangladesh_flag,
            R.drawable.bhutan_flag,
            R.drawable.china_flag,
            R.drawable.iran_flag,
            R.drawable.japan_flag,
            R.drawable.nepal_flag,
            R.drawable.pakistan_flag,
            R.drawable.sri_lanka_flag,
            R.drawable.turkey_flag
    };

    private boolean isFirstSelection = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.sprinnerId);
        countryNames = getResources().getStringArray(R.array.country_names);
        population = getResources().getStringArray(R.array.population);
        spinner = findViewById(R.id.sprinnerId);
        CustomAdapter adapter = new CustomAdapter(this, flags, countryNames, population);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (isFirstSelection == true) {
                    isFirstSelection = false;
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
