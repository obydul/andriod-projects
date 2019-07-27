package andriod.obydul.com.loginapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText edtName, edtPassword;
    private TextView txtAttemp;
    private Button btnLogin;
    private int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtName = findViewById(R.id.edtName);
        edtPassword = findViewById(R.id.edtPassword);

        txtAttemp = findViewById(R.id.txtAttemp);
        btnLogin = findViewById(R.id.btnLogin);

        txtAttemp.setText("Your remaining attemp is : 3");

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtName.getText().toString();
                String password = edtPassword.getText().toString();
                if (name.equals("obydul") && password.equals("bilkes")){
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(intent);
                } else {
                    counter --;
                    txtAttemp.setText("Your remaining attemp is : " + counter);

                    if (counter==0){
                        btnLogin.setEnabled(false);
                    }
                }
            }
        });
    }
}
