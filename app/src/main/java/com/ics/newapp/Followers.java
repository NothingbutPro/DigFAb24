package com.ics.newapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Followers extends AppCompatActivity {

    Toolbar toolbar_follow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_followers);

        toolbar_follow = (Toolbar)findViewById(R.id.toolbar_follow);
        toolbar_follow.setNavigationIcon(R.drawable.arrow);
        toolbar_follow.setNavigationOnClickListener(new View.OnClickListener() {
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
