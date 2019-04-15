package com.ics.newapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.ics.newapp.R;

public class InvoceVActivity extends AppCompatActivity {
    Toolbar toolbar_Inv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoce_v);

        toolbar_Inv = (Toolbar)findViewById(R.id.toolbar_Invp);

        toolbar_Inv.setNavigationIcon(R.drawable.arrow);
        toolbar_Inv.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //   stopActivityTask();
                onBackPressed();
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}