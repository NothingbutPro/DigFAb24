package com.ics.newapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Check_out extends AppCompatActivity {
    Button place_or;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);
        place_or = findViewById(R.id.place_or);
        place_or.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Check_out.this , Order_Placed.class);
                startActivity(intent);
            }
        });
    }
}
