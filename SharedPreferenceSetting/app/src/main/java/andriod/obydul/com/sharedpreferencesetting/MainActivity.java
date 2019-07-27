package andriod.obydul.com.sharedpreferencesetting;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = findViewById(R.id.linearLayerid);

        if (loadColor()!=getResources().getColor(R.color.colorPrimary)){
            linearLayout.setBackgroundColor(loadColor());
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_layout, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.redcolorId){
            linearLayout.setBackgroundColor(getResources().getColor(R.color.Red));
            storeColor(getResources().getColor(R.color.Red));
        }
        if (item.getItemId()==R.id.greencolorId){
            linearLayout.setBackgroundColor(getResources().getColor(R.color.Green));
            storeColor(getResources().getColor(R.color.Green));
        }
        if (item.getItemId()==R.id.yellocolorId){
            linearLayout.setBackgroundColor(getResources().getColor(R.color.Yellow));
            storeColor(getResources().getColor(R.color.Yellow));
        }

        return super.onOptionsItemSelected(item);
    }

    private void storeColor(int color) {
        SharedPreferences sharedPreferences = getSharedPreferences("selectedColor", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("myColor", color);
        editor.commit();
    }

    private int loadColor(){
        SharedPreferences sharedPreferences = getSharedPreferences("selectedColor", Context.MODE_PRIVATE);
        int selectedColor = sharedPreferences.getInt("myColor", getResources().getColor(R.color.colorPrimary));
        return selectedColor;
    }
}
