package com.ics.newapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Order_Products extends AppCompatActivity {
    String namewa;
    EditText na_ed;
    Button Dealer_Order_Info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order__products);
        Dealer_Order_Info = findViewById(R.id.dnid);
        namewa = getIntent().getStringExtra("namewa");
        na_ed = findViewById(R.id.na_ed);
        Dealer_Order_Info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Order_Products.this , com.ics.newapp.Dealer_Order_Info.class);
                startActivity(intent);
            }
        });
        na_ed.setText(namewa);

    }
}
