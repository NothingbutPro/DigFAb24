package com.ics.newapp;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ics.newapp.SeasonManager.SessionManager;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends AppCompatActivity {
    Toolbar toolbar_profile;
    TextView following,follower,viewers;
    CircleImageView profile_image;
    TextView mainid;
    TextView proname;
    LinearLayout comname , cop;
    SessionManager sessionManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mainid = findViewById(R.id.mainid);
        comname = findViewById(R.id.comname);
        cop = findViewById(R.id.copx);
        sessionManager = new SessionManager(this);
        following = (TextView)findViewById(R.id.following);
        follower = (TextView)findViewById(R.id.follower);
        proname =findViewById(R.id.pronamemn);
        proname.setText(getIntent().getStringExtra("ideaname"));
        profile_image = findViewById(R.id.profile_image);
        viewers= findViewById(R.id.viewers);
        if(sessionManager.isLoggedIn().equals("Manufacturer"))
        {
            profile_image.setImageResource(R.drawable.complogo);
            proname.setText("Nike Brand and NIKE, Inc.");
        }
        if(sessionManager.isLoggedIn().equals("Dealers"))
        {
            profile_image.setImageResource(R.drawable.boythree);
            proname.setText("Parag Sharma");
            mainid.setText("Footwear dealer");
        }if(sessionManager.isLoggedIn().equals("Buyers"))
        {
            profile_image.setImageResource(R.drawable.boythree);
            proname.setText("Nilesh Upadhaya ");
            mainid.setText("");
            cop.setVisibility(View.GONE);
            comname.setVisibility(View.GONE);
        }
        if(sessionManager.isLoggedIn().equals("Affiliate Marketer"))
        {
//            profile_image.setImageResource(R.drawable.boythree);
            proname.setText("Prakash Upadhaya ");
            mainid.setText("Affiliate Marketer");
        }
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

