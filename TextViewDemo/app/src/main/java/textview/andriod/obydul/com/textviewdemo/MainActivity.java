package textview.andriod.obydul.com.textviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView txtname;
    private Button btnlogin, btnlogout;
    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnlogin = (Button) findViewById(R.id.btnlogin);
        btnlogout = (Button) findViewById(R.id.btnlogout);

        txtname = (TextView) findViewById(R.id.txtname);
        txtname.setText("Bilkes Jahan");

    }

    public void showMessage(View v){
        if (v.getId()==R.id.btnlogin) {
            Log.d("tag", "Login button is clicked!");
        }
        else if (v.getId()==R.id.btnlogout){
            Log.d("tag", "Logout button is clicked!");
        }
    }

}
