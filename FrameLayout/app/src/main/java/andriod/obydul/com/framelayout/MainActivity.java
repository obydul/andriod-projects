package andriod.obydul.com.framelayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imageJihad, imageBappi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageJihad = findViewById(R.id.imagejihad);
        imageBappi = findViewById(R.id.imagebappi);

        imageJihad.setOnClickListener(this);
        imageBappi.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.imagejihad){
            imageJihad.setVisibility(View.GONE);
            imageBappi.setVisibility(View.VISIBLE);
        }
        else if (v.getId()==R.id.imagebappi){
            imageBappi.setVisibility(View.GONE);
            imageJihad.setVisibility(View.VISIBLE);
        }

    }
}
