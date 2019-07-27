package andriod.obydul.com.mycheckboxdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private CheckBox chkMilk, chkSugar, chkWater;
    private Button btnShow;
    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chkMilk = findViewById(R.id.chkMilk);
        chkSugar = findViewById(R.id.chkSugar);
        chkWater = findViewById(R.id.chkWater);

        btnShow = findViewById(R.id.btnShow);
        txtResult = findViewById(R.id.txtResult);

        btnShow.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        StringBuilder stringBuilder = new StringBuilder();
        if (chkMilk.isChecked()){
            String value = chkMilk.getText().toString();
            stringBuilder.append(value + " is ordered\n" );
        }
        if (chkSugar.isChecked()){
            String value = chkSugar.getText().toString();
            stringBuilder.append(value + " is ordered\n" );
        }

        if (chkWater.isChecked()){
            String value = chkWater.getText().toString();
            stringBuilder.append(value + " is ordered\n" );
        }
        txtResult.setText(stringBuilder);
    }
}
