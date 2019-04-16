package com.ics.newapp;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.ics.newapp.adapter.MyAdapter;
import com.ics.newapp.adapter.TenderAdapter;

public class FregmentSection extends AppCompatActivity {
    TabLayout tabtender;
    ViewPager viewPagerten;
    Toolbar toolbar_tender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fregment_section);

        toolbar_tender = (Toolbar) findViewById(R.id.toolbar_tender);
        // Title and subtitle
        // toolbar_prof.setTitle(R.string.about_toolbar_title);
        toolbar_tender.setNavigationIcon(R.drawable.arrow);
        toolbar_tender.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //   stopActivityTask();
                onBackPressed();
            }
        });

        tabtender=(TabLayout)findViewById(R.id.tabtender);
        viewPagerten=(ViewPager)findViewById(R.id.viewPagerten);

        tabtender.addTab(tabtender.newTab().setText("Pending Tender"));
        tabtender.addTab(tabtender.newTab().setText("Completed Tender"));
        tabtender.addTab(tabtender.newTab().setText("New Tender"));
        tabtender.setTabGravity(TabLayout.GRAVITY_FILL);
        tabtender.setSmoothScrollingEnabled(true);
        tabtender.setSelectedTabIndicatorColor(Color.parseColor("#FFFFFF"));
        tabtender.setSelectedTabIndicatorHeight((int) (3 * getResources().getDisplayMetrics().density));
        tabtender.setTabTextColors(Color.parseColor("#CECACA"), Color.parseColor("#ffffff"));
        final TenderAdapter tenderAdapter = new TenderAdapter(this,getSupportFragmentManager(), tabtender.getTabCount());
        viewPagerten.setAdapter(tenderAdapter);

        viewPagerten.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabtender));

        tabtender.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPagerten.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
