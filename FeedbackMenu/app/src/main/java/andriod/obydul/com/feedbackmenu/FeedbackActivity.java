package andriod.obydul.com.feedbackmenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FeedbackActivity extends AppCompatActivity implements View.OnClickListener {

    private Button sendButton, clearButton;
    private EditText txtName, txtMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        // back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        sendButton = findViewById(R.id.sendButtonId);
        clearButton = findViewById(R.id.clearButtonId);

        txtName = findViewById(R.id.txtName);
        txtMessage = findViewById(R.id.txtMessage);

        sendButton.setOnClickListener(this);
        clearButton.setOnClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

        try {
            String name = txtName.getText().toString();
            String message = txtMessage.getText().toString();

            if (v.getId() == R.id.sendButtonId) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/email");

                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"obydul.islam20@gmail.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "Feedback from app");
                intent.putExtra(Intent.EXTRA_TEXT, "Name : " + name + "\n Message : " + message);
                startActivity(Intent.createChooser(intent, "Fedback with"));

            } else if (v.getId() == R.id.clearButtonId) {
                txtName.setText("");
                txtMessage.setText("");
            }

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Exception : " + e, Toast.LENGTH_SHORT).show();
        }


    }
}
