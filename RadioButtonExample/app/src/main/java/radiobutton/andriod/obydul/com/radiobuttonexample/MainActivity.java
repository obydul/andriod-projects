package radiobutton.andriod.obydul.com.radiobuttonexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private RadioGroup radioGroup;
    private RadioButton genderButton;
    private Button btnshow;
    private TextView txtshow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        radioGroup = (RadioGroup) findViewById(R.id.radiogroup);
        btnshow = (Button) findViewById(R.id.show);
        txtshow = (TextView) findViewById(R.id.txtshow);

        btnshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedid = radioGroup.getCheckedRadioButtonId();
                genderButton = (RadioButton) findViewById(selectedid);
                String value = genderButton.getText().toString();
                txtshow.setText("You have selected : "+value);
            }
        });
    }
}
