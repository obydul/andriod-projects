package gradient.andriod.obydul.com.gradientbackground;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private String[] countryNames;
    private ListView listView;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Gradient Background");

        countryNames = getResources().getStringArray(R.array.country_names);
        listView = findViewById(R.id.listView);

        adapter = new ArrayAdapter<String>(MainActivity.this, R.layout.sample_view, R.id.txtview, countryNames);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String value = adapter.getItem(position);
        Toast.makeText(MainActivity.this, value, Toast.LENGTH_SHORT).show();
    }

}
