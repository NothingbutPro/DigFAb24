package com.ics.newapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Add_Products extends AppCompatActivity {
Button add_pro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__products);
        add_pro = findViewById(R.id.add_pro);
        add_pro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Add_Products.this , Navigation.class);
                startActivity(intent);
            }
        });
    }
}
