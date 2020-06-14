package com.example.and_279930.View;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.and_279930.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class RegisterActivity extends AppCompatActivity {
    EditText registerUser, registerMail, registerPass;
    Button createAcc;
    ProgressBar progressBar;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
        FirebaseApp.initializeApp(this);

        registerUser = findViewById(R.id.registerUsername);
        registerPass = findViewById(R.id.passRegister);
        registerMail = findViewById(R.id.emailRegister);
        createAcc = findViewById(R.id.buttonRegister);
        progressBar = findViewById(R.id.progressBarRegister);

        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            finish();
        }

        createAcc.setOnClickListener(v -> {
            String user = registerUser.getText().toString();
            String pass = registerPass.getText().toString();
            String mail = registerMail.getText().toString();

            if (TextUtils.isEmpty(user)) {
                registerUser.setError("A username is required");
                return;
            }

            if (TextUtils.isEmpty(pass)) {
                registerPass.setError("A password is required");
                return;
            }

            if (registerPass.length() < 6) {
                registerPass.setError("Password must contain at least 6 characters");
            }

            if (TextUtils.isEmpty(mail)) {
                registerMail.setError("An E-mail address is required");
                return;
            }

            progressBar.setVisibility(View.VISIBLE);

            firebaseAuth.createUserWithEmailAndPassword(mail, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(RegisterActivity.this, "New User Created", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                    } else {
                        Toast.makeText(RegisterActivity.this, "Error!" + Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                    }
                }
            });
        });
    }
}