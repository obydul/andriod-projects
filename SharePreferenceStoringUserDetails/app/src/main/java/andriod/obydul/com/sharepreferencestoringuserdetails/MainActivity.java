package andriod.obydul.com.sharepreferencestoringuserdetails;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtName, edtPassword;
    private Button btnSave, btnLoad;
    private TextView txtShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtName = findViewById(R.id.edtusername);
        edtPassword = findViewById(R.id.edtpassword);
        btnSave = findViewById(R.id.btnsave);
        btnLoad = findViewById(R.id.btnload);
        txtShow = findViewById(R.id.txtDetails);

        btnSave.setOnClickListener(this);
        btnLoad.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btnsave){
            String name = edtName.getText().toString();
            String pass = edtPassword.getText().toString();

            if (name.equals("") && pass.equals("")){
                Toast.makeText(MainActivity.this, "Please enter data ", Toast.LENGTH_SHORT).show();
            } else {
                SharedPreferences sharedPreferences = getSharedPreferences("userdetails", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("username", name);
                editor.putString("password", pass);
                editor.commit();
                edtName.setText("");
                edtPassword.setText("");
                Toast.makeText(MainActivity.this, "Data saved successfully ", Toast.LENGTH_SHORT).show();
            }

        }
        else if (v.getId()==R.id.btnload){
            SharedPreferences sharedPreferences = getSharedPreferences("userdetails", Context.MODE_PRIVATE);
            if (sharedPreferences.contains("username") && sharedPreferences.contains("password")){
                String username = sharedPreferences.getString("username", "Data not found");
                String pass = sharedPreferences.getString("password", "data not found");

                txtShow.setText(username + "\n" + pass);
            }
        }

    }
}
