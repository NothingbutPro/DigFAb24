package com.ics.newapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Profile_Manu_Dealer extends AppCompatActivity {

    TextView txt_analytics, txt_Average,txt_overvew,txt_Products;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile__manu__dealer);

        txt_analytics=findViewById(R.id.analytics);

        txt_overvew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profile_Manu_Dealer.this,ProfileActivity.class);
                startActivity(intent);
                // finish();
            }
        });

        txt_Products.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profile_Manu_Dealer.this,ProfileActivity.class);
                startActivity(intent);
                // finish();
            }
        });

        txt_Average.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profile_Manu_Dealer.this,ProfileActivity.class);
                startActivity(intent);
                // finish();
            }
        });

        txt_analytics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profile_Manu_Dealer.this,ProfileActivity.class);
                startActivity(intent);
               // finish();
            }
        });
    }
}
