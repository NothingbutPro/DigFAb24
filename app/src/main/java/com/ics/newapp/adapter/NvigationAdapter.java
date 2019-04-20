package com.ics.newapp.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.widget.Toast;

import com.ics.newapp.SeasonManager.SessionManager;
import com.ics.newapp.fregment.Buyers_Deals;
import com.ics.newapp.fregment.CompletedFragment;
import com.ics.newapp.fregment.Manufacturer_Deals;
import com.ics.newapp.fregment.PendingFragment;
import com.ics.newapp.fregment.Pending_Deals;
import com.ics.newapp.fregment.RelatedFragment;
import com.ics.newapp.fregment.SignInFreg;
import com.ics.newapp.fregment.SignUpFreg;

public class NvigationAdapter extends FragmentPagerAdapter {
    private Context myContext;
    SessionManager  sessionManager;
    int totalTabs;

    public NvigationAdapter(Context context, FragmentManager fm, int totalTabs) {
        super(fm);
        sessionManager = new SessionManager(context);
        myContext = context;
        this.totalTabs = totalTabs;
    }

    // this is for fragment tabs
    @Override
    public Fragment getItem(int position) {
        switch (position) {
           /* case 0:
                Toast.makeText(myContext, ""+sessionManager.isLoggedIn(), Toast.LENGTH_SHORT).show();
                if(sessionManager.isLoggedIn().equals("Dealers"))
                {
                    Manufacturer_Deals manufacturer_deals = new Manufacturer_Deals();
                    return manufacturer_deals;
                }else {
                    RelatedFragment relatedFragment = new RelatedFragment();
                    return relatedFragment;
                }*/

            case 0:
                if(sessionManager.isLoggedIn().equals("Dealers"))
                {
                    PendingFragment buyers_deals = new PendingFragment();
                    return buyers_deals;
                }else
                    {
                        PendingFragment buyers_deals = new PendingFragment();
                   return buyers_deals;
                }
//
//            case 1:
//                if(sessionManager.isLoggedIn().equals("Dealers"))
//                {
//                    Pending_Deals buyers_deals = new Pending_Deals();
//                    return buyers_deals;
//                }else
//                    {
//                    /*CompletedFragment completedFragment = new CompletedFragment();
//                    return completedFragment;*/
//                }

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
