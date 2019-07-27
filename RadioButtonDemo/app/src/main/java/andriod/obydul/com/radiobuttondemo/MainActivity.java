package andriod.obydul.com.radiobuttondemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RadioGroup radioGroup;
    private RadioButton genderButton;
    private Button btnShow;
    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup = findViewById(R.id.radioGroupId);
        btnShow = findViewById(R.id.btnShow);
        txtResult = findViewById(R.id.resultText);
        btnShow.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int selectedId = radioGroup.getCheckedRadioButtonId();
        genderButton = findViewById(selectedId);
        String value = genderButton.getText().toString();
        txtResult.setText("You have selected " + value);
    }
}
