package andriod.obydul.com.recyclerviewexample;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    int[] images = {
            R.drawable.afganistan_flag,
            R.drawable.armenia_flag,
            R.drawable.azerbijan_flag,
            R.drawable.bahrain_flag,
            R.drawable.bangladesh_flag,
            R.drawable.iran_flag,
            R.drawable.maldives_flag,
            R.drawable.pakistan_flag,
            R.drawable.turkey_flag
    };

    String[] title, desc;
    MyAdapter myAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerId);

        title = getResources().getStringArray(R.array.country_name);
        desc = getResources().getStringArray(R.array.country_desc);

        myAdapter = new MyAdapter(this, title, desc, images);

        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        myAdapter.setOnItemClickListener(new MyAdapter.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Toast.makeText(getApplicationContext(), "onitem click: " + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(int position, View v) {
                Toast.makeText(getApplicationContext(), "onItemLong click: " + position, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
