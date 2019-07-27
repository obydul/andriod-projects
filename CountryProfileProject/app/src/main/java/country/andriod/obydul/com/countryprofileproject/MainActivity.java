package country.andriod.obydul.com.countryprofileproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnbangla, btnturkey, btnpak;
    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnbangla = findViewById(R.id.btnbangladesh);
        btnturkey = findViewById(R.id.btnturkey);
        btnpak = findViewById(R.id.btnpakistan);

        btnbangla.setOnClickListener(this);
        btnturkey.setOnClickListener(this);
        btnpak.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btnbangladesh){
            intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("name", "Bangladesh");
            startActivity(intent);
        }
        if (v.getId()==R.id.btnturkey){
            intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("name", "Turkey");
            startActivity(intent);
        }
        if (v.getId()==R.id.btnpakistan){
            intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("name", "Pakistan");
            startActivity(intent);
        }
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alerBuilder;
        alerBuilder = new AlertDialog.Builder(MainActivity.this);
        alerBuilder.setIcon(R.drawable.faq);
        alerBuilder.setTitle(R.string.title_text);
        alerBuilder.setMessage(R.string.message_text);
        alerBuilder.setCancelable(false);

        alerBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        alerBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog alertDialog = alerBuilder.create();
        alertDialog.show();

    }
}
