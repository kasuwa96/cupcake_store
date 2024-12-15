package com.example.thecuppy;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.thecuppy.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {

    ActivityRegisterBinding binding;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        databaseHelper = new DatabaseHelper(this);

        binding.sgnup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = binding.NameT.getText().toString().trim();
                String email = binding.emailTS.getText().toString().trim();
                String password = binding.PwT.getText().toString().trim();
                String confirmPassword = binding.PwT1.getText().toString().trim();

                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                    Toast.makeText(RegisterActivity.this, "Please fill in all the fields", Toast.LENGTH_SHORT).show();
                } else if (!isValidEmail(email)) {
                    Toast.makeText(RegisterActivity.this, "Invalid email address", Toast.LENGTH_SHORT).show();
                } else if (!password.equals(confirmPassword)) {
                    Toast.makeText(RegisterActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                } else {
                    if (databaseHelper.checkEmail(email)) {
                        Toast.makeText(RegisterActivity.this, "Email already exists", Toast.LENGTH_SHORT).show();
                    } else {
                        boolean isInserted = databaseHelper.insertUser(name, email, password);
                        if (isInserted) {
                            Toast.makeText(RegisterActivity.this, "Registration successful", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            Toast.makeText(RegisterActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
    }

    private boolean isValidEmail(CharSequence email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
