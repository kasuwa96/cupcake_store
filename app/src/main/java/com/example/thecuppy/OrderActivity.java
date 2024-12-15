package com.example.thecuppy;


import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends Activity {
    private TextView emailTextView, contactNumberTextView, addressTextView, amountTextView, quantityTextView;
    private Button confirmOrderButton;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        emailTextView = findViewById(R.id.emailTextView);
        contactNumberTextView = findViewById(R.id.contactNumberTextView);
        addressTextView = findViewById(R.id.addressTextView);
        amountTextView = findViewById(R.id.amountTextView);
        quantityTextView = findViewById(R.id.quantityTexttView);
        confirmOrderButton = findViewById(R.id.obtn);
        dbHelper = new DatabaseHelper(this);

        // Retrieve the order details from the intent
        Intent intent = getIntent();
        if (intent != null) {
            String email = intent.getStringExtra("email");
            String contactNumber = intent.getStringExtra("contactNumber");
            String address = intent.getStringExtra("address");
            String amount = intent.getStringExtra("amount");
            String quantity = intent.getStringExtra("quantity");

            // Display the order details in the TextViews
            emailTextView.setText(email);
            contactNumberTextView.setText(contactNumber);
            addressTextView.setText(address);
            amountTextView.setText(amount);
            quantityTextView.setText(quantity);

            confirmOrderButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String email = emailTextView.getText().toString();
                    String contactNumber = contactNumberTextView.getText().toString();
                    String address = addressTextView.getText().toString();
                    String amount = amountTextView.getText().toString();
                    String quantity = quantityTextView.getText().toString();

                    // Insert values into the database
                    SQLiteDatabase db = dbHelper.getWritableDatabase();
                    ContentValues values = new ContentValues();
                    values.put("email", email);
                    values.put("contact_number", contactNumber);
                    values.put("address", address);
                    values.put("amount", amount);
                    values.put("quantity", quantity);
                    long newRowId = db.insert("orderTable", null, values);

                    if (newRowId != -1) {
                        Toast.makeText(OrderActivity.this, "Order placed successfully", Toast.LENGTH_SHORT).show();
                        Intent homeIntent = new Intent(OrderActivity.this, HomeActivity.class);
                        startActivity(homeIntent);
                        finish();
                    } else {
                        Toast.makeText(OrderActivity.this, "Failed to place order", Toast.LENGTH_SHORT).show();
                    }

                    db.close();
                }
            });
        }
    }
}
