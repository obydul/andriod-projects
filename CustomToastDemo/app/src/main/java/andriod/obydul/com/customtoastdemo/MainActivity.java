package andriod.obydul.com.customtoastdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginButton = findViewById(R.id.btnLogin);
        loginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        LayoutInflater inflater = getLayoutInflater();
        View customView =  inflater.inflate(R.layout.customtoast_layout, (ViewGroup) findViewById(R.id.customtoast_id));
        Toast toast = new Toast(MainActivity.this);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.setView(customView);
        toast.show();
    }
}
