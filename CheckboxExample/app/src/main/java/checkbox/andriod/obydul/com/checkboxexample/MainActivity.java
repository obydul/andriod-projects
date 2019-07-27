package checkbox.andriod.obydul.com.checkboxexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private CheckBox chkmilk, chksugar, chkwater;
    private Button btnshow;
    private TextView txtresult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chkmilk = (CheckBox)findViewById(R.id.chkmilk);
        chksugar = (CheckBox)findViewById(R.id.chksugar);
        chkwater = (CheckBox)findViewById(R.id.chkwater);

        btnshow = (Button) findViewById(R.id.btnshow);

        txtresult = (TextView) findViewById(R.id.txtresult);

        btnshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder stringBuilder = new StringBuilder();

                if (chkmilk.isChecked()){
                    String value = chkmilk.getText().toString();
                    stringBuilder.append(value + " is ordered" + "\n");
                }
                if (chksugar.isChecked()){
                    String value = chksugar.getText().toString();
                    stringBuilder.append(value + " is ordered" + "\n");
                }
                 if (chkwater.isChecked()){
                    String value = chkwater.getText().toString();
                    stringBuilder.append(value + " is ordered");
                }
                txtresult.setText(stringBuilder);
            }
        });
    }
}
