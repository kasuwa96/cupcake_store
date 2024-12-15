package com.example.thecuppy;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class StoreActivity extends AppCompatActivity {

    private Button classicButton, anniversaryButton, valentineButton, birthdayButton, themedButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        // Initialize the buttons
        classicButton = findViewById(R.id.cB);
        anniversaryButton = findViewById(R.id.aB);
        valentineButton = findViewById(R.id.vB);
        birthdayButton = findViewById(R.id.bB);
        themedButton = findViewById(R.id.tB);

        // Set click listener for the Classic button
        classicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Direct to ClassicActivity
                Intent intent = new Intent(StoreActivity.this, ClassicActivity.class);
                startActivity(intent);
            }
        });

        // Set click listener for the Anniversary button
        anniversaryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Direct to AnniversaryActivity
                Intent intent = new Intent(StoreActivity.this, AnniversaryActivity.class);
                startActivity(intent);
            }
        });

        // Set click listener for the Valentine button
        valentineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Direct to ValentineActivity
                Intent intent = new Intent(StoreActivity.this, ValentineActivity.class);
                startActivity(intent);
            }
        });

        // Set click listener for the Birthday button
        birthdayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Direct to BirthdayActivity
                Intent intent = new Intent(StoreActivity.this, BirthdayActivity.class);
                startActivity(intent);
            }
        });

        // Set click listener for the Themed button
        themedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Direct to ThemedActivity
                Intent intent = new Intent(StoreActivity.this, ThemeActivity.class);
                startActivity(intent);
            }
        });
    }
}
