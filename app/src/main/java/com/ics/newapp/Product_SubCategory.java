package com.ics.newapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;

import com.ics.newapp.adapter.ExpandableListAdapter;

public class Product_SubCategory extends AppCompatActivity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product__sub_category);

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.ex_lv);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        // Listview Group click listener
        expListView.setOnGroupClickListener(new OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // Toast.makeText(getApplicationContext(),
                // "Group Clicked " + listDataHeader.get(groupPosition),
                // Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Collapsed",
                        Toast.LENGTH_SHORT).show();

            }
        });

        // Listview on child click listener
        expListView.setOnChildClickListener(new OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub
                Toast.makeText(
                        getApplicationContext(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();
                Intent intent = new Intent(v.getContext() , Main3Activity.class);
                intent.putExtra("namewa" ,  listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition));
                startActivity(intent);
                return false;
            }
        });
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Mobiles & Tablets");
        listDataHeader.add("Electronics");
        listDataHeader.add("Fashion");

        // Adding child data
        List<String> top250 = new ArrayList<String>();
        top250.add("Sumsung");
        top250.add("IBall");
        top250.add("IPhone");
        top250.add("Micromax");
        top250.add("China Phone");
        top250.add("SmartPhones");
        top250.add("Feacher Phones");

        List<String> nowShowing = new ArrayList<String>();
        nowShowing.add("Laptop Stores");
        nowShowing.add("Desktop Stores");
        nowShowing.add("Camera & Accessories");
        nowShowing.add("Storage Device");
        nowShowing.add("Mobile Accessories");
        nowShowing.add("Gaming");

        List<String> comingSoon = new ArrayList<String>();
        comingSoon.add("Mens Fashion Store");
        comingSoon.add("Women Fashion Store");
        comingSoon.add("Kids Wear");
        comingSoon.add("Sandals & Floters");
        comingSoon.add("Jewellery");

        listDataChild.put(listDataHeader.get(0), top250); // Header, Child data
        listDataChild.put(listDataHeader.get(1), nowShowing);
        listDataChild.put(listDataHeader.get(2), comingSoon);
    }
}
