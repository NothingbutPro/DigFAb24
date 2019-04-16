package com.ics.newapp.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.ics.newapp.fregment.CompletedTenderFreg;
import com.ics.newapp.fregment.NewTenderFreg;
import com.ics.newapp.fregment.PendingTenderFreg;


public class TenderAdapter extends FragmentPagerAdapter {

    private Context myContext;
    int totalTabs;

    public TenderAdapter(Context context, FragmentManager fm, int totalTabs) {
        super(fm);
        myContext = context;
        this.totalTabs = totalTabs;
    }

    // this is for fragment tabs
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                PendingTenderFreg pendingTenderFreg = new PendingTenderFreg();
                return pendingTenderFreg;
            case 1:
                CompletedTenderFreg completedTenderFreg = new CompletedTenderFreg();
                return completedTenderFreg;
            case 2:
                NewTenderFreg newTenderFreg = new NewTenderFreg();
                return newTenderFreg;
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
