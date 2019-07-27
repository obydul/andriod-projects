package andriod.obydul.com.countryprofile;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button bgdButton, turkeyButton, pakiButton;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bgdButton = findViewById(R.id.bgdBtn);
        turkeyButton = findViewById(R.id.turkeyBtn);
        pakiButton = findViewById(R.id.pakiBtn);
        bgdButton.setOnClickListener(this);
        turkeyButton.setOnClickListener(this);
        pakiButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bgdBtn) {
            intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("name", "Bangladesh");
            startActivity(intent);
        }
        if (v.getId() == R.id.turkeyBtn) {
            intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("name", "Turkey");
            startActivity(intent);
        }
        if (v.getId() == R.id.pakiBtn) {
            intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("name", "Pakistan");
            startActivity(intent);
        }
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alertDialogBuilder;
        alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder.setIcon(R.drawable.faq);
        alertDialogBuilder.setTitle("This is a title");
        alertDialogBuilder.setMessage("Are u exit?");
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
