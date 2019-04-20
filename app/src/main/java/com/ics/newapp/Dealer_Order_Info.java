package com.ics.newapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Dealer_Order_Info extends AppCompatActivity {
    TextView ortxid;
    Button oktk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dealer__order__info);
        oktk = findViewById(R.id.oktk);
        oktk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dealer_Order_Info.this , Navigation.class);
                startActivity(intent);
            }
        });
//        ortxid.setText("Nike Brand and Nike INC.");
    }
}
