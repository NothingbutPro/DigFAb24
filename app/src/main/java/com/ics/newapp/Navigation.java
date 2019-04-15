package com.ics.newapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.ics.newapp.SeasonManager.SessionManager;
import com.ics.newapp.adapter.MyAdapter;
import com.ics.newapp.adapter.NvigationAdapter;
import com.ics.newapp.fregment.BuyerFragment;

public class Navigation extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    TabLayout tabLayout;
    ViewPager viewPager;
    SessionManager sessionManager;
    TextView id_name , type;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        this.getSupportActionBar().setDisplayHomeAsUpEnabled(false);
       // ((AppCompatActivity)ScrollingActivity.this).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        sessionManager = new SessionManager(this);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View header = navigationView.getHeaderView(0);
        imageView= header.findViewById(R.id.imageView);
        id_name = header.findViewById(R.id.id_name);
        type = header.findViewById(R.id.type);
        tabLayout=(TabLayout)findViewById(R.id.tabLayout);
        viewPager=(ViewPager)findViewById(R.id.viewPager1);
        sessionManager = new SessionManager(this);
        if(sessionManager.isLoggedIn().equals("Dealers"))
        {
            id_name.setText("Parag Sharma");
            type.setText("Footwear Dealer");
            tabLayout.addTab(tabLayout.newTab().setText("Manufacturer Deals"));
            tabLayout.addTab(tabLayout.newTab().setText("Buyers Deals"));
            tabLayout.addTab(tabLayout.newTab().setText("Pending Deals"));
            navigationView = (NavigationView)findViewById(R.id.nav_view);
            Menu nav_Menu = navigationView.getMenu();
            nav_Menu.findItem(R.id.tender).setVisible(false);
        }if(sessionManager.isLoggedIn().equals("Manufacturer"))
        {
            id_name.setText("Nike Brand and NIKE, Inc.");
            type.setText("media.relations@nike.com");
            imageView.setImageResource(R.drawable.complogo);

            navigationView = (NavigationView)findViewById(R.id.nav_view);
            Menu nav_Menu = navigationView.getMenu();
            nav_Menu.findItem(R.id.tender).setVisible(false);
            nav_Menu.findItem(R.id.tenders).setVisible(false);
            tabLayout.addTab(tabLayout.newTab().setText("Related Deals"));
            tabLayout.addTab(tabLayout.newTab().setText("Pending Deals"));
            tabLayout.addTab(tabLayout.newTab().setText("Completed Deals"));
        }



        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        if(sessionManager.isLoggedIn().equals("Buyers")){
            tabLayout.setVisibility(View.GONE);
            navigationView = (NavigationView)findViewById(R.id.nav_view);
            Menu nav_Menu = navigationView.getMenu();
            nav_Menu.findItem(R.id.tenders).setVisible(false);
            FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
            tx.replace(R.id.content_frame, new BuyerFragment());
            tx.commit();


        }else {
            tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

            tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#FFFFFF"));
            tabLayout.setSelectedTabIndicatorHeight((int) (3 * getResources().getDisplayMetrics().density));
            tabLayout.setTabTextColors(Color.parseColor("#CECACA"), Color.parseColor("#ffffff"));
            final NvigationAdapter nvigationAdapter = new NvigationAdapter(this,getSupportFragmentManager(), tabLayout.getTabCount());
            viewPager.setAdapter(nvigationAdapter);
        }

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


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.locsisdf) {
            Intent intent = new Intent(Navigation.this , MainActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            Intent intent = new Intent(Navigation.this,ProfileActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {
            Intent intent = new Intent(Navigation.this,Followers.class);
            startActivity(intent);


        } else if (id == R.id.nav_share) {
            Intent intent = new Intent(Navigation.this,BillingHistory.class);
            startActivity(intent);

        } else if (id == R.id.nav_send) {

        }
        else if (id == R.id.tender) {
            Intent intent = new Intent(Navigation.this,TenderHistory.class);
            startActivity(intent);
        } else if (id == R.id.tenders) {
            Intent intent = new Intent(Navigation.this,Tender_list.class);
            startActivity(intent);
        }      else if (id == R.id.chat) {
            Intent intent = new Intent(Navigation.this,ChatActivity.class);
            startActivity(intent);
        }
        else if (id == R.id.accounting) {
            Intent intent = new Intent(Navigation.this,Accounting.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
