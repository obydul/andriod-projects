package country.andriod.obydul.com.countryprofileproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    private ImageView imageView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        imageView = findViewById(R.id.imageViewId);
        textView = findViewById(R.id.txtView);

        Bundle bundle = getIntent().getExtras();
        if (bundle!=null){
            String countryName = bundle.getString("name");
            showDetails(countryName);

        }
    }
    void showDetails(String name){
        if (name.equals("Bangladesh")){
            imageView.setImageResource(R.drawable.bangladesh_parliament);
            textView.setText(R.string.bgd_text);
        }
        if (name.equals("Turkey")){
            imageView.setImageResource(R.drawable.turkey_parliament);
            textView.setText(R.string.turkey_text);
        }
        if (name.equals("Pakistan")){
            imageView.setImageResource(R.drawable.pakistan_parliament);
            textView.setText(R.string.paki_text);
        }

    }
}
