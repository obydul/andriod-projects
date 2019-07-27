package edittext.andriod.obydul.com.edittextexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
private EditText txtnum1, txtnum2;
private Button btnadd, btnsub;
private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtnum1 = (EditText) findViewById(R.id.edittext1);
        txtnum2 = (EditText) findViewById(R.id.edittext2);


        btnadd = (Button) findViewById(R.id.btnadd);
        btnsub = (Button) findViewById(R.id.btnsub);
        btnadd.setOnClickListener(this);
        btnsub.setOnClickListener(this);


        result = (TextView) findViewById(R.id.resulttextview);
    }

    @Override
    public void onClick(View v) {
        try {
            String num1 = txtnum1.getText().toString();
            String num2 = txtnum2.getText().toString();

            double number1 = Double.parseDouble(num1);
            double number2 = Double.parseDouble(num2);


            if (v.getId()==R.id.btnadd){
                double sum = number1 + number2;
                result.setText("Result : " + sum);

            } else if (v.getId()==R.id.btnsub){
                double sub = number1 - number2;
                result.setText("Result : " + sub);
            }
        } catch (Exception e){
            Toast.makeText(MainActivity.this, "Please Enter Number", Toast.LENGTH_SHORT).show();
        }

    }
}
