package com.example.thecuppy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ThemeActivity extends AppCompatActivity {

    private Button buttonb1, buttonb2, buttonb3, buttonb4;
    private TextView priceTextView, priceTextView1, priceTextView2, priceTextView3;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme);

        priceTextView = findViewById(R.id.priceTextView8);
        priceTextView1 = findViewById(R.id.priceTextView9);
        priceTextView2 = findViewById(R.id.priceTextView10);
        priceTextView3 = findViewById(R.id.priceTextView11);

        buttonb1 = findViewById(R.id.t1);
        buttonb2 = findViewById(R.id.t2);
        buttonb3 = findViewById(R.id.t3);
        buttonb4 = findViewById(R.id.t4);

        buttonb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String price = priceTextView.getText().toString();
                navigateToCart(price);
            }
        });

        buttonb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String price = priceTextView1.getText().toString();
                navigateToCart(price);
            }
        });

        buttonb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String price = priceTextView2.getText().toString();
                navigateToCart(price);
            }
        });

        buttonb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String price = priceTextView3.getText().toString();
                navigateToCart(price);
            }
        });
    }

    private void navigateToCart(String price) {
        Intent intent = new Intent(ThemeActivity.this, CartActivity.class);
        intent.putExtra("price", price);
        startActivity(intent);
    }
}






