package gridview.andriod.obydul.com.gridviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

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

    String[] countryNames;
    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = (GridView) findViewById(R.id.gridViewId);
        countryNames = getResources().getStringArray(R.array.country_names);

        CustomAdapter adapter = new CustomAdapter(MainActivity.this,countryNames, flags);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = countryNames[position];
                Toast.makeText(MainActivity.this, value, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
