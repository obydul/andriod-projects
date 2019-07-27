package andriod.obydul.com.sqlitedatalistview;

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
    private EditText edtId, edtName;
    private Button btnSave, btnShow, btnUpdate, btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(MainActivity.this);
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        edtId = findViewById(R.id.edtId);
        edtName = findViewById(R.id.edtName);

        btnSave = findViewById(R.id.btnSave);
        btnShow = findViewById(R.id.btnShow);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);

        btnSave.setOnClickListener(this);
        btnShow.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String id = edtId.getText().toString();
        String name = edtName.getText().toString();

        if (v.getId() == R.id.btnSave) {
            if (id.equals("") && name.equals("")) {
                Toast.makeText(getApplicationContext(), "Please enter all data", Toast.LENGTH_SHORT).show();
            } else {
                long value = databaseHelper.saveData(id, name);
                if (value > -1) {
                    Toast.makeText(getApplicationContext(), "Insert successfully in row " + value, Toast.LENGTH_SHORT).show();
                    edtId.setText("");
                    edtName.setText("");
                } else {
                    Toast.makeText(getApplicationContext(), "Can not insert properly", Toast.LENGTH_SHORT).show();
                }
            }

        } else if (v.getId() == R.id.btnShow) {
            Intent intent = new Intent(MainActivity.this, ListDataActivity.class);
            startActivity(intent);

        } else if (v.getId() == R.id.btnUpdate) {
            Boolean isUpdated = databaseHelper.updateData(id, name);
            if (isUpdated == true) {
                Toast.makeText(getApplicationContext(), "data is updated", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "data is not updated", Toast.LENGTH_SHORT).show();
            }

        } else if (v.getId() == R.id.btnDelete) {
            int value = databaseHelper.deleteData(id);
            if (value < 0) {
                Toast.makeText(getApplicationContext(), "data is not deleted", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(getApplicationContext(), "data is deleted", Toast.LENGTH_SHORT).show();
            }

        }

    }
}
