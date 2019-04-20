package com.ics.newapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Call_splash_screen extends AppCompatActivity {


    private static int SPLASH_TIME_OUT = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_splash_screen);


        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                try{

                    Intent intent = new Intent(Call_splash_screen.this, Diary_Maintain.class);
                    startActivity(intent);
                    finish();

                }catch (Exception e) {
                }
//                    Intent i = new Intent(SplashActivity.this, LoginActivity.class);
//                    startActivity(i);

                // close this activity
//                    finish();
            }
        }, SPLASH_TIME_OUT);



    }
}
