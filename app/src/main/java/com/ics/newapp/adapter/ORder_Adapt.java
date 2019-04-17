package com.ics.newapp.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.ics.newapp.Order_Placed;
import com.ics.newapp.SeasonManager.SessionManager;
import com.ics.newapp.fregment.Dealer_to_buyer;
import com.ics.newapp.fregment.Manufacturer_to_Dealer;
import com.ics.newapp.fregment.Order_Delivered;
import com.ics.newapp.fregment.Order_Taken;

public class ORder_Adapt extends FragmentPagerAdapter {

    private Context myContext;
    int totalTabs;
    SessionManager sessionManager;
    public ORder_Adapt(Context context, FragmentManager fm, int totalTabs) {
        super(fm);
        sessionManager = new SessionManager(context);
        myContext = context;
        this.totalTabs = totalTabs;
    }



    // this is for fragment tabs
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                if(sessionManager.isLoggedIn().equals("Dealers")){
                    Manufacturer_to_Dealer manufacturer_to_dealer = new Manufacturer_to_Dealer();
                    return  manufacturer_to_dealer;
                }else{
                    Order_Taken order_taken = new Order_Taken();
                    return order_taken;
                }

            case 1:
                if(sessionManager.isLoggedIn().equals("Dealers")){
                    Dealer_to_buyer dealer_to_buyer = new Dealer_to_buyer();
                    return  dealer_to_buyer;
                }else {
                    Order_Delivered order_delivered = new Order_Delivered();
                    return order_delivered;
                }
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