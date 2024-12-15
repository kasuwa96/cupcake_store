package com.example.thecuppy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    private Button vsButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Initialize the button
        vsButton = findViewById(R.id.vsB);

        // Set click listener for the button
        vsButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Direct to StoreActivity
                Intent intent = new Intent(HomeActivity.this, StoreActivity.class);
                startActivity(intent);
            }
        });
    }

}