package com.ics.newapp.fregment;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.ics.newapp.Addto_cart;
import com.ics.newapp.MainActivity;
import com.ics.newapp.R;
import com.ics.newapp.adapter.HeaderAdapter;

public class BuyerFragment extends Fragment {
    LinearLayout proid;
    final int duration = 1000;
    final int pixelsToMove = 390;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    Button btn;
    HeaderAdapter madapter;
    private RecyclerView rv_autoScroll;
    private final Runnable SCROLLING_RUNNABLE = new Runnable() {

        @Override
        public void run() {
            rv_autoScroll.smoothScrollBy(pixelsToMove, 0);
            mHandler.postDelayed(this, duration);
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_buyer, container, false);
        //     sliderLayout = view.findViewById(R.id.imageSlider);


        proid = view.findViewById(R.id.proid);
        proid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Addto_cart.class);
                startActivity(intent);
            }
        });


        return view;
//        return inflater.inflate(R.layout.manufacure, container, false);

    }

//    @Override
//    public void onPrepareOptionsMenu(Menu menu) {
//        MenuItem item=menu.findItem(R.id.card_shopping);
//        item.setVisible(true);
//
////            item2.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
////                @Override
////                public boolean onMenuItemClick(MenuItem item) {
////                    Fragment view_creat=new Create_Activity();
////                    FragmentManager fragmentManager = getFragmentManager();
////                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
////                    fragmentTransaction.replace(R.id.content_frame,view_creat);
////                    fragmentTransaction.addToBackStack(null);
////                    fragmentTransaction.commit();
////
////
////                    return false;
////                }
////            });
//
//
//    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        HorizontalScrollView hscrol=view.findViewById(R.id.horizontal_scroll);

        rv_autoScroll = (RecyclerView)view.findViewById(R.id.marqueList);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);


        rv_autoScroll.setLayoutManager(layoutManager);
        rv_autoScroll.setHasFixedSize(true);
        madapter = new HeaderAdapter(getContext());
        rv_autoScroll.setAdapter(madapter);

        rv_autoScroll.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int lastItem = layoutManager.findLastCompletelyVisibleItemPosition();
                if(lastItem == layoutManager.getItemCount()-1){
                    mHandler.removeCallbacks(SCROLLING_RUNNABLE);
                    Handler postHandler = new Handler();
                    postHandler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            rv_autoScroll.setAdapter(null);
                            rv_autoScroll.setAdapter(madapter);
                            mHandler.postDelayed(SCROLLING_RUNNABLE, 2000);
                        }
                    }, 2000);
                }
            }
        });
        mHandler.postDelayed(SCROLLING_RUNNABLE, 2000);
    }
}

