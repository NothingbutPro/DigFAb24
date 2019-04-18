package com.ics.newapp;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ics.newapp.SeasonManager.SessionManager;
import com.ics.newapp.adapter.MyAdapter;
import com.ics.newapp.adapter.ORder_Adapt;

public class Order_Informations extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    SessionManager sessionManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order__informations);
        sessionManager = new SessionManager(this);

        tabLayout=(TabLayout)findViewById(R.id.tabLayout);
        viewPager=(ViewPager)findViewById(R.id.viewPager);
        if(sessionManager.isLoggedIn().equals("Buyers"))
        {
            tabLayout.addTab(tabLayout.newTab().setText("Tracked Order"));
            tabLayout.addTab(tabLayout.newTab().setText("Completed Order"));
        }else {
            if(sessionManager.isLoggedIn().equals("Manufacturer"))
            {
                tabLayout.addTab(tabLayout.newTab().setText("Order To Dealer"));
            }else {
                tabLayout.addTab(tabLayout.newTab().setText("Order to Manufacturer"));
                tabLayout.addTab(tabLayout.newTab().setText("Order from Buyer"));
            }


        }

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ORder_Adapt adapter = new ORder_Adapt(this,getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}

