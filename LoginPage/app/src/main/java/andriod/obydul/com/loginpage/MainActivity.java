package andriod.obydul.com.loginpage;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    DatabaseHelper databaseHelper;
    private EditText edtUsernameLogin, edtPasswordLogin;
    private Button btnSignInLogin, btnSignUpLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUsernameLogin = findViewById(R.id.edtusernameLogin);
        edtPasswordLogin = findViewById(R.id.edtpasswordLogin);
        btnSignInLogin = findViewById(R.id.btnSignInLogin);
        btnSignUpLogin = findViewById(R.id.btnSignUpLogin);

        btnSignInLogin.setOnClickListener(this);
        btnSignUpLogin.setOnClickListener(this);

        databaseHelper = new DatabaseHelper(MainActivity.this);
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();


    }

    @Override
    public void onClick(View v) {
        String username = edtUsernameLogin.getText().toString();
        String password = edtPasswordLogin.getText().toString();


        if (v.getId()==R.id.btnSignInLogin){
            Boolean result = databaseHelper.findPassword(username, password);

            if (result==true){
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            } else {
                Toast.makeText(getApplicationContext(), "username and password did not match", Toast.LENGTH_SHORT).show();
            }

        }
        else if (v.getId()==R.id.btnSignUpLogin){
            Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
            startActivity(intent);
        }

    }
}
