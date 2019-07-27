package andriod.obydul.com.backbuttonexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FeedbackActivity extends AppCompatActivity implements View.OnClickListener {

    private Button sendButton, clearButton;
    private EditText edtName, edtMessage;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

//        back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        sendButton = findViewById(R.id.sendButton);
        clearButton = findViewById(R.id.clearButton);

        edtName = findViewById(R.id.edtName);
        edtMessage = findViewById(R.id.edtMessage);

        sendButton.setOnClickListener(this);
        clearButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String name = edtName.getText().toString();
        String message = edtMessage.getText().toString();

        if (v.getId() == R.id.sendButton) {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/email");

            intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"obydul.islam20@gmail.com"});
            intent.putExtra(Intent.EXTRA_SUBJECT, "Feedback from app");
            intent.putExtra(Intent.EXTRA_TEXT, "Name : " + name + "\n message : " + message);
            startActivity(Intent.createChooser(intent, "Feedback with"));
        } else if (v.getId() == R.id.clearButton) {
            edtName.setText("");
            edtMessage.setText("");
        }


    }
}
