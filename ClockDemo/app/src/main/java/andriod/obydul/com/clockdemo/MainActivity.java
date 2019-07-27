package andriod.obydul.com.clockdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.TextClock;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
private TextClock textClock;
private AnalogClock analogClock;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textClock = findViewById(R.id.textClock);
        analogClock = findViewById(R.id.analogClock);
        textClock.setOnClickListener(this);
        analogClock.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.analogClock){
            Toast.makeText(MainActivity.this,"Analog clock", Toast.LENGTH_SHORT).show();
        }
        if (v.getId()==R.id.textClock){
            Toast.makeText(MainActivity.this,"Text clock", Toast.LENGTH_SHORT).show();
        }
    }
}
