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
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtSignUpEmail, edtSignUpPass;
    private Button btnSignUp;
    private TextView txtSignIn;
    private ProgressBar prSignUp;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        this.setTitle("Sign Up Activity");

        mAuth = FirebaseAuth.getInstance();

        edtSignUpEmail = findViewById(R.id.signUpEmail);
        edtSignUpPass = findViewById(R.id.signUpPassword);
        btnSignUp = findViewById(R.id.signUpButton);
        txtSignIn = findViewById(R.id.signInTextId);
        prSignUp = findViewById(R.id.progressIdSignUp);
        btnSignUp.setOnClickListener(this);
        txtSignIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.signUpButton:
                userRegister();
                break;

            case R.id.signInTextId:
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                break;
        }

    }

    private void userRegister() {
        String email = edtSignUpEmail.getText().toString().trim();
        String pass = edtSignUpPass.getText().toString().trim();

        if (email.isEmpty()) {
            edtSignUpEmail.setError("Enter an email address");
            edtSignUpEmail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            edtSignUpEmail.setError("Enter an email address");
            edtSignUpEmail.requestFocus();
            return;
        }

        if (pass.isEmpty()) {
            edtSignUpPass.setError("Enter a password");
            edtSignUpPass.requestFocus();
            return;
        }

        if (pass.length() < 6) {
            edtSignUpPass.setError("Minimum length of a password should be 6");
            edtSignUpPass.requestFocus();
            return;
        }
        prSignUp.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                prSignUp.setVisibility(View.GONE);
                if (task.isSuccessful()) {
                    finish();//sign up activity finish
                    Intent intent = new Intent(SignUpActivity.this, ProfileActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    //Toast.makeText(getApplicationContext(), "Register is successfull", Toast.LENGTH_LONG).show();

                } else {
                    if (task.getException() instanceof FirebaseAuthUserCollisionException){
                        Toast.makeText(getApplicationContext(), "User Already registered", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Error : "+task.getException().getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

    }
}
