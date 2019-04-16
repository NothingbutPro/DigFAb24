package com.ics.newapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Affiliate_Marketing extends AppCompatActivity {

    Button btn_new_affiliate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affiliate__marketing);

        btn_new_affiliate= (Button) findViewById(R.id.btn_post);

        btn_new_affiliate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Affiliate_Marketing.this,New_Affiliate_Program.class);
                startActivity(intent);
            }
        });
    }
}
