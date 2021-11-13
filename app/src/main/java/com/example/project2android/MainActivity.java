package com.example.project2android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAuth mAuth;
    private EditText  et_email, et_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        et_email = findViewById(R.id.log_et_email);
        et_password = findViewById(R.id.log_password);
        findViewById(R.id.tv_log_singUp).setOnClickListener(this);
        findViewById(R.id.bt_signIn).setOnClickListener(this);
        findViewById(R.id.tv_forgetPassword).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_signIn:
                userLogin();
                break;

            case R.id.tv_log_singUp:
                startActivity(new Intent(this,MapsActivity.class));
                break;

            case R.id.tv_forgetPassword:
                startActivity(new Intent(this,HomeActivity2.class));
                break;
        }
    }


    private boolean validateLinkForm() {
        boolean valid = true;
        String email = et_email.getText().toString();
        String password = et_password.getText().toString();

        if (TextUtils.isEmpty(email)) {
            et_email.setError(getString(R.string.field_required));
            valid = false;
        } else {
            et_email.setError(null);
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            et_email.setError(getString(R.string.validEmail));
            valid = false;
        }else {
            et_email.setError(null);
        }
        if (TextUtils.isEmpty(password)) {
            et_password.setError(getString(R.string.field_required));
            valid = false;
        } else {
            et_password.setError(null);
        }
        return valid;
    }

    private void userLogin() {
        String email =et_email.getText().toString();
        String password =et_password.getText().toString();

        if (!validateLinkForm()) {
            return;
        }
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    startActivity(new Intent(MainActivity.this,HomeActivity2.class));
                }
                else {
                    Toast.makeText(MainActivity.this,getString(R.string.addFailed),Toast.LENGTH_LONG)
                            .show();

                }
            }
        });
            }


    }


