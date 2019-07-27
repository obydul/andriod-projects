package andriod.obydul.com.firebasestoredata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private EditText edtName, edtAge;
    private Button btnSave, btnLoad;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseReference = FirebaseDatabase.getInstance().getReference("students");

        edtName = findViewById(R.id.edtName);
        edtAge = findViewById(R.id.edtAge);
        btnSave = findViewById(R.id.btnSave);
        btnLoad = findViewById(R.id.btnLoadData);


        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DetailsActivity.class);
                startActivity(intent);
            }
        });


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });
    }
    public void saveData(){
        String name = edtName.getText().toString().trim();
        String age = edtAge.getText().toString().trim();

        String key = databaseReference.push().getKey();

        Student student = new Student(name, age);
        databaseReference.child(key).setValue(student);

        Toast.makeText(getApplicationContext(), "Student info is added", Toast.LENGTH_LONG).show();

        edtName.setText("");
        edtAge.setText("");





    }
}
