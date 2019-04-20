package com.ics.newapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Calender_Activity extends AppCompatActivity {
    Button setcal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender_);
        setcal = findViewById(R.id.setcal);
        setcal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Calender_Activity.this, Navigation.class);
                Toast.makeText(Calender_Activity.this, "Remainder set", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
    }
}

