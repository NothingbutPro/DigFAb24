package com.ics.newapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Order_Placed extends AppCompatActivity {
    Button donbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order__placed);
        donbtn = findViewById(R.id.donbtn);
        donbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Order_Placed.this , Navigation.class);
                startActivity(intent);
            }
        });

    }
}
