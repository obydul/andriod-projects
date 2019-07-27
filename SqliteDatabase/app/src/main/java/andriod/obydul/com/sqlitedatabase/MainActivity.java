package andriod.obydul.com.sqlitedatabase;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    DatabaseHelper databaseHelper;

    private EditText edtName, edtAge, edtGender, edtId;
    private Button btnSave, btnDisplay, btnUpdate, btnDelete, btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtName = findViewById(R.id.edtName);
        edtAge = findViewById(R.id.edtAge);
        edtGender = findViewById(R.id.edtGender);
        edtId = findViewById(R.id.edtId);
        btnSave = findViewById(R.id.btnAdd);
        btnDisplay = findViewById(R.id.btnDisplay);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        btnClear = findViewById(R.id.btnClear);

        databaseHelper = new DatabaseHelper(MainActivity.this);
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        btnSave.setOnClickListener(this);
        btnDisplay.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnClear.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String name = edtName.getText().toString();
        String age = edtAge.getText().toString();
        String gender = edtGender.getText().toString();
        String id = edtId.getText().toString();

        if (v.getId() == R.id.btnAdd) {
            long rowid = databaseHelper.insertData(name, age, gender);

            if (rowid == -1) {
                Toast.makeText(getApplicationContext(), "Not " + rowid + " Successfully inserted", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Insert " + rowid + " Successfully", Toast.LENGTH_SHORT).show();
            }
        }
        if (v.getId() == R.id.btnDisplay) {
            Cursor cursor = databaseHelper.displayData();
            if (cursor.getCount() == 0) {
                showData("Error", "No data found");
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            while (cursor.moveToNext()) {
                stringBuffer.append("ID : " + cursor.getString(0) + "\n");
                stringBuffer.append("Name : " + cursor.getString(1) + "\n");
                stringBuffer.append("Age : " + cursor.getString(2) + "\n");
                stringBuffer.append("Gender : " + cursor.getString(3) + "\n\n\n");
            }

            showData("ResultSet", stringBuffer.toString());

        } else if (v.getId() == R.id.btnUpdate) {
            if (id.equals("")) {
                Toast.makeText(MainActivity.this, "Id is required", Toast.LENGTH_SHORT).show();
            } else {
                Boolean isUpdated = databaseHelper.updateData(id, name, age, gender);
                if (isUpdated == true) {
                    Toast.makeText(MainActivity.this, "Data Updated", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Data not Updated", Toast.LENGTH_SHORT).show();
                }
            }

        }
        else if (v.getId() == R.id.btnDelete) {
            if (id.equals("")) {
                Toast.makeText(MainActivity.this, "Id is required", Toast.LENGTH_SHORT).show();
            } else {
                int value = databaseHelper.deleteData(id);
                if (value > 0) {
                    Toast.makeText(MainActivity.this, "Data Deleted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Data not Deleted", Toast.LENGTH_SHORT).show();
                }
            }
        }
        else if (v.getId() == R.id.btnClear) {
            edtId.setText("");
            edtName.setText("");
            edtAge.setText("");
            edtGender.setText("");
        }

    }

    public void showData(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setCancelable(true);
        builder.show();
    }

}
