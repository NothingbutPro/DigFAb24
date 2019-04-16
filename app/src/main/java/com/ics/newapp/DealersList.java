package com.ics.newapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class DealersList extends AppCompatActivity {
    Toolbar toolbar_dealers;
    TextView addDealer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dealers_list);

        toolbar_dealers = (Toolbar)findViewById(R.id.toolbar_dealers);
        toolbar_dealers.setNavigationIcon(R.drawable.arrow);
        toolbar_dealers.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //   stopActivityTask();
                onBackPressed();
            }
        });

        addDealer = (TextView)findViewById(R.id.addDealer);
        addDealer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DealersList.this,AddDealer.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
