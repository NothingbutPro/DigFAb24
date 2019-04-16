package com.ics.newapp.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.ics.newapp.Order_Placed;
import com.ics.newapp.fregment.Order_Delivered;
import com.ics.newapp.fregment.Order_Taken;

public class ORder_Adapt extends FragmentPagerAdapter {

    private Context myContext;
    int totalTabs;

    public ORder_Adapt(Context context, FragmentManager fm, int totalTabs) {
        super(fm);
        myContext = context;
        this.totalTabs = totalTabs;
    }



    // this is for fragment tabs
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Order_Taken order_taken = new Order_Taken();
                return order_taken;
            case 1:
                Order_Delivered order_delivered = new Order_Delivered();
                return order_delivered;
            default:
                return null;
        }
    }
    // this counts total number of tabs
    @Override
    public int getCount() {
        return totalTabs;
    }
}