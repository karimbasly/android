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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAuth mAuth;
    private EditText et_name, et_email, et_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);
        mAuth = FirebaseAuth.getInstance();
        findViewById(R.id.bt_singUp).setOnClickListener(this);

        et_name = findViewById(R.id.signUp_et_name);
        et_email = findViewById(R.id.signUp_et_email);
        et_password = findViewById(R.id.signUp_password);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.bt_singUp:
                singUp();
                break;

        }
    }
    private boolean validateLinkForm() {
            boolean valid = true;
            String password = et_password.getText().toString();
            String name = et_name.getText().toString();
            String email = et_email.getText().toString();

            if (TextUtils.isEmpty(name)) {
                et_name.setError(getString(R.string.field_required));
                valid = false;
            } else {
                et_name.setError(null);
            }
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

        private void singUp() {
            if (!validateLinkForm()) {
                return;
            }
            String name=et_name.getText().toString();
            String email =et_email.getText().toString();
            String password =et_password.getText().toString();
            mAuth.createUserWithEmailAndPassword(email,password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                User user =new User(name,email);
                                FirebaseDatabase database = FirebaseDatabase.getInstance();
                                DatabaseReference myUsersRef = database.getReference("users");
                                myUsersRef
                                        .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                        .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()){
                                            Toast.makeText(SignupActivity.this,getString(R.string.addsuccessfuly),Toast.LENGTH_LONG)
                                                    .show();
                                            startActivity(new Intent(SignupActivity.this,HomeActivity2.class));

                                        }
                                        else {
                                            Toast.makeText(SignupActivity.this,getString(R.string.addFailed),Toast.LENGTH_LONG)
                                                    .show();

                                        }
                                    }
                                });
                            }else {
                                Toast.makeText(SignupActivity.this,getString(R.string.addFailed),Toast.LENGTH_LONG)
                                        .show();

                            }
                        }
                    });



        }


    }
