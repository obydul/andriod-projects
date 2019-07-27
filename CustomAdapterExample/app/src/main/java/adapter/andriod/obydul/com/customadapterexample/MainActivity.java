package adapter.andriod.obydul.com.customadapterexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private String[] countryNames;
    private  int[] flags = {R.drawable.afganistan_flag,
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView = findViewById(R.id.listViewId);
        countryNames = getResources().getStringArray(R.array.country_name);

        CustomAdapter adapter = new CustomAdapter(MainActivity.this,countryNames,flags);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = countryNames[position];
                Toast.makeText(MainActivity.this, value, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
