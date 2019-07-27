package andriod.obydul.com.myswitchdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private Switch switchs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        switchs = findViewById(R.id.switchid);

        switchs.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
              if (isChecked){
                  Toast.makeText(MainActivity.this,"On", Toast.LENGTH_SHORT).show();
              } else {
                  Toast.makeText(MainActivity.this,"Off", Toast.LENGTH_SHORT).show();
              }
            }
        });
    }
}
