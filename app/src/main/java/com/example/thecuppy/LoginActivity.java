package com.example.thecuppy;



import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText emailEditText, passwordEditText;
    private Button loginButton, registerButton;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailEditText = findViewById(R.id.emailT);
        passwordEditText = findViewById(R.id.pwT);
        loginButton = findViewById(R.id.logB);
        registerButton = findViewById(R.id.regB);
        databaseHelper = new DatabaseHelper(this);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                    Toast.makeText(LoginActivity.this, "Please enter email and password", Toast.LENGTH_SHORT).show();
                } else {
                    if (databaseHelper.checkEmailPassword(email, password)) {
                        if (email.equalsIgnoreCase("admin@gmail.com")) {
                            Toast.makeText(LoginActivity.this, "Admin login successful", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(LoginActivity.this, AdminActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                            startActivity(intent);
                        }
                        finish();
                    } else {
                        Toast.makeText(LoginActivity.this, "Invalid email or password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
