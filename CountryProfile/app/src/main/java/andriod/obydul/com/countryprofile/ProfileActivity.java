package andriod.obydul.com.countryprofile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    private TextView textView;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        textView = findViewById(R.id.txtView);
        image = findViewById(R.id.imgView);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String countryName = bundle.getString("name");
            showDetails(countryName);
        }
    }

    public void showDetails(String countryName) {
        if (countryName.equals("Bangladesh")) {
            textView.setText(R.string.bgd_text);
            image.setImageResource(R.drawable.bangladesh_parliament);
        }
        if (countryName.equals("Turkey")) {
            textView.setText(R.string.turkey_text);
            image.setImageResource(R.drawable.turkey_parliament);
        }
        if (countryName.equals("Pakistan")) {
            textView.setText(R.string.paki_text);
            image.setImageResource(R.drawable.pakistan_parliament);
        }
    }
}
