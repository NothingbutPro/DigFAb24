package com.ics.newapp;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    Toolbar toolbar_profile;
    TextView following,follower,viewers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        following = (TextView)findViewById(R.id.following);
        follower = (TextView)findViewById(R.id.follower);
        viewers= findViewById(R.id.viewers);
        viewers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this,ViewersActivity.class);
                startActivity(intent);
            }
        });
        toolbar_profile = (Toolbar) findViewById(R.id.toolbar_profile);
        // Title and subtitle
        // toolbar_prof.setTitle(R.string.about_toolbar_title);
        toolbar_profile.setNavigationIcon(R.drawable.arrow);
        toolbar_profile.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //   stopActivityTask();
                onBackPressed();
            }
        });

        following.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this,Followers.class);
                startActivity(intent);
                finish();
            }
        });

        follower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this,Followers.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}

