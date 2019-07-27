package andriod.obydul.com.firebaselogin;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtSignInEmail, edtSignInPass;
    private Button btnSignIn;
    private TextView txtSignUp;
    private ProgressBar prSignIn;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Sign In Activity");

        edtSignInEmail = findViewById(R.id.signInEmailEdit);
        edtSignInPass = findViewById(R.id.signInPassEdit);
        btnSignIn = findViewById(R.id.signInButton);
        txtSignUp = findViewById(R.id.signUpTextId);
        prSignIn = findViewById(R.id.progressId);
        btnSignIn.setOnClickListener(this);
        txtSignUp.setOnClickListener(this);
        mAuth = FirebaseAuth.getInstance();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.signInButton:
                userLogin();


                break;

            case R.id.signUpTextId:
                Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(intent);
                break;
        }

    }

    private void userLogin() {
        String email = edtSignInEmail.getText().toString().trim();
        String pass = edtSignInPass.getText().toString().trim();

        if (email.isEmpty()) {
            edtSignInEmail.setError("Enter an email address");
            edtSignInEmail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            edtSignInEmail.setError("Enter an email address");
            edtSignInEmail.requestFocus();
            return;
        }

        if (pass.isEmpty()) {
            edtSignInPass.setError("Enter a password");
            edtSignInPass.requestFocus();
            return;
        }

        if (pass.length() < 6) {
            edtSignInPass.setError("Minimum length of a password should be 6");
            edtSignInPass.requestFocus();
            return;
        }

        prSignIn.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                prSignIn.setVisibility(View.GONE);
                if (task.isSuccessful()){
                    finish();//sign in activity finish
                    Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Login Unsuccessful", Toast.LENGTH_SHORT).show();
                }

            }
        });




    }
}
