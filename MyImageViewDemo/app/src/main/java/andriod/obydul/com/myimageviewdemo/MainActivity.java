package andriod.obydul.com.myimageviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView imageView1, imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);

        imageView1.setOnClickListener(this);
        imageView2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.imageView1) {
            Toast.makeText(MainActivity.this, "You Select Jihad1 Image", Toast.LENGTH_SHORT).show();
        }
        if (v.getId() == R.id.imageView2) {
            Toast.makeText(MainActivity.this, "You Select Jihad2 Image", Toast.LENGTH_SHORT).show();
        }
    }
}
