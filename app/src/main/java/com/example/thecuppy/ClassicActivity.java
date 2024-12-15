package com.example.thecuppy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class ClassicActivity extends AppCompatActivity {


    private Button buttonb1, buttonb2, buttonb3, buttonb4;
    private TextView priceTextView, priceTextView1, priceTextView2, priceTextView3;




        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_classic);

            priceTextView = findViewById(R.id.priceTextView4);
            priceTextView1 = findViewById(R.id.priceTextView5);
            priceTextView2 = findViewById(R.id.priceTextView6);
            priceTextView3 = findViewById(R.id.priceTextView7);

            buttonb1 = findViewById(R.id.c1);
            buttonb2 = findViewById(R.id.c2);
            buttonb3 = findViewById(R.id.c3);
            buttonb4 = findViewById(R.id.c4);

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
            Intent intent = new Intent(ClassicActivity.this, CartActivity.class);
            intent.putExtra("price", price);
            startActivity(intent);
        }
    }


