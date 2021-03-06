package com.ics.newapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.ics.newapp.SeasonManager.SessionManager;

public class Profile_Manu_Dealer extends AppCompatActivity {

    TextView txt_analytics, txt_Average,txt_overvew,txt_Products;
    TextView pronamemn;
    TextView mainid;
    SessionManager sessionManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile__manu__dealer);

        txt_analytics=findViewById(R.id.analytics);
        sessionManager = new SessionManager(this);
        mainid = findViewById(R.id.mainid);
        txt_Average=findViewById(R.id.average);
        txt_Products=findViewById(R.id.products);
        pronamemn= findViewById(R.id.pronamemn);

        pronamemn.setText(getIntent().getStringExtra("ideaname"));
        if(sessionManager.isLoggedIn().equals("Manufacturer"))
        {
            mainid.setText("Dealer");
        }else if(sessionManager.isLoggedIn().equals("Dealers"))
        {
            mainid.setText("Manufacturer");
        }
//        txt_overvew.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Profile_Manu_Dealer.this,ProfileActivity.class);
//                startActivity(intent);
//                // finish();
//            }
//        });

        txt_Products.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profile_Manu_Dealer.this,Product_SubCategory.class);
                startActivity(intent);
                // finish();
            }
        });

        txt_Average.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profile_Manu_Dealer.this,Profile_Average_perchase.class);
                startActivity(intent);
                // finish();
            }
        });

        txt_analytics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profile_Manu_Dealer.this,ProfileActivity.class);
                intent.putExtra("ideaname" , mainid.getText().toString());
                startActivity(intent);
               // finish();
            }
        });
    }
}
