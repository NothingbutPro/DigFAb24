package com.ics.newapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class ViewersActivity extends AppCompatActivity {
    Toolbar toolbar_views;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewers);

        toolbar_views = (Toolbar) findViewById(R.id.toolbar_views);

        // toolbar_prof.setTitle(R.string.about_toolbar_title);
        toolbar_views.setNavigationIcon(R.drawable.arrow);
        toolbar_views.setNavigationOnClickListener(new View.OnClickListener() {
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