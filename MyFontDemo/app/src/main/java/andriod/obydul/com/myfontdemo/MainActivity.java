package andriod.obydul.com.myfontdemo;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private TextView textView1, textView2;
    private Typeface typeface1, typeface2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView1 = findViewById(R.id.textOne);
        textView2 = findViewById(R.id.textTwo);

        typeface1 = Typeface.createFromAsset(getAssets(), "font/Rubik_Bold.ttf");
        textView1.setTypeface(typeface1);

        typeface2 = Typeface.createFromAsset(getAssets(), "font/Rubik_Italic.ttf");
        textView2.setTypeface(typeface2);
    }
}
