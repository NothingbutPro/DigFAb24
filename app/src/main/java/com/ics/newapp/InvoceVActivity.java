package com.ics.newapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.ics.newapp.R;
import com.ics.newapp.SeasonManager.SessionManager;

public class InvoceVActivity extends AppCompatActivity {
    Toolbar toolbar_Inv ;
    TextView fromsd , tosd;
    SessionManager sessionManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoce_v);
        fromsd = findViewById(R.id.fromsd);
        tosd = findViewById(R.id.tosd);
        sessionManager = new SessionManager(this);
        if(sessionManager.isLoggedIn().equals("Buyers"))
        {
            fromsd.setText("Parag Sharma");
            tosd.setText("Nilesh Upadhaya");
        }
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