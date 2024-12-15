package com.example.thecuppy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;
public class BirthdayActivity extends AppCompatActivity {

    private Button buttonb1, buttonb2, buttonb3, buttonb4;
    private TextView priceTextView, priceTextView1, priceTextView2, priceTextView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthday);

        priceTextView = findViewById(R.id.priceTextView);
        priceTextView1 = findViewById(R.id.priceTextView1);
        priceTextView2 = findViewById(R.id.priceTextView2);
        priceTextView3 = findViewById(R.id.priceTextView3);

        buttonb1 = findViewById(R.id.b1);
        buttonb2 = findViewById(R.id.b2);
        buttonb3 = findViewById(R.id.b3);
        buttonb4 = findViewById(R.id.b4);

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
        Intent intent = new Intent(BirthdayActivity.this, CartActivity.class);
        intent.putExtra("price", price);
        startActivity(intent);
    }
}

