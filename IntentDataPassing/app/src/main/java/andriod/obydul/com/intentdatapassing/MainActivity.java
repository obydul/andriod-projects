package andriod.obydul.com.intentdatapassing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.btnFirst);
        editText = (EditText) findViewById(R.id.txtFirst);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtEditData = editText.getText().toString().trim();
                String btnData = button.getText().toString().trim();
                if (txtEditData.isEmpty()) {
                    Log.d("abc", "pasteData is empty");
                    Toast.makeText(MainActivity.this, "Please enter value ", Toast.LENGTH_SHORT).show();
                } else {
                    Log.d("abcd", txtEditData);
                    Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                    //intent.putExtra("tag", "Bangladesh is my motherland");
                    intent.putExtra("edtValue", btnData + " " + txtEditData);
                    startActivity(intent);
                }
            }
        });
    }
}
