package andriod.obydul.com.myedittextdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editText1, editText2;
    private Button btnAdd, btnSub, btnClear;
    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        btnAdd = findViewById(R.id.addButton);
        btnSub = findViewById(R.id.subButton);
        btnClear = findViewById(R.id.clearButton);
        txtResult = findViewById(R.id.resultText);

        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnClear.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        try {
            String number1 = editText1.getText().toString();
            String number2 = editText2.getText().toString();

            Double num1 = Double.parseDouble(number1);
            Double num2 = Double.parseDouble(number2);

            if (v.getId() == R.id.addButton) {
                double sum = num1 + num2;
                txtResult.setText("Result : " + sum);
            }
            if (v.getId() == R.id.subButton) {
                double sum = num1 - num2;
                txtResult.setText("Result : " + sum);
            }

            if (v.getId() == R.id.clearButton) {
                editText1.setText("");
                editText2.setText("");
                txtResult.setText("");
            }
        } catch (Exception e) {
            Toast.makeText(MainActivity.this, "Please enter numbers ", Toast.LENGTH_SHORT).show();
        }

    }
}
