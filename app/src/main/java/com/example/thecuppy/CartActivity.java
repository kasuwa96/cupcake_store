package com.example.thecuppy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.thecuppy.databinding.ActivityCartBinding;

public class CartActivity extends AppCompatActivity {

    private EditText emailEditText, contactNumberEditText, addressEditText, quantityEditText;
    private Button pBTN;

    private TextView amountTextView;

    ActivityCartBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        amountTextView = binding.amountTextView1;
        Intent intent = getIntent();
        String price = intent.getStringExtra("price");
        amountTextView.setText("Amount: " + price);
        emailEditText = findViewById(R.id.emailEditText);
        contactNumberEditText = findViewById(R.id.contactNumberEditText);
        addressEditText = findViewById(R.id.addressEditText);
        amountTextView = findViewById(R.id.amountTextView1);
        quantityEditText = findViewById(R.id.quantityEditText);
        pBTN = findViewById(R.id.pBTN);

        pBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString();
                String contactNumber = contactNumberEditText.getText().toString();
                String address = addressEditText.getText().toString();
                String amount = amountTextView.getText().toString();
                String quantity = quantityEditText.getText().toString();

                // Create an intent to start OrderActivity
                Intent intent = new Intent(CartActivity.this, OrderActivity.class);
                intent.putExtra("email", email);
                intent.putExtra("contactNumber", contactNumber);
                intent.putExtra("address", address);
                intent.putExtra("amount", amount);
                intent.putExtra("quantity", quantity);
                startActivity(intent);
            }
        });
    }
}










