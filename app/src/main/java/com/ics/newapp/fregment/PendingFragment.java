package com.ics.newapp.fregment;


import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ics.newapp.Calender_Activity;
import com.ics.newapp.Call_splash_screen;
import com.ics.newapp.ChatActivity;
import com.ics.newapp.MainActivity;
import com.ics.newapp.ProfileActivity;
import com.ics.newapp.R;
import com.ics.newapp.SeasonManager.SessionManager;
import com.ics.newapp.adapter.MyListAdapter;
import com.ics.newapp.model.MyListData;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class PendingFragment extends Fragment {
    RelativeLayout relativeLayout;
    TextView name , name2 , name3;
    TextView curdate, curtime, month;
    private TextView mTextMessage;
    Calendar myCalendar;
    MyListData[] myListData;
    ProgressDialog dialog;
    DatePickerDialog.OnDateSetListener date;
    private String dateFlage;
    View view;
SessionManager sessionManager;

    LinearLayout ll_click;

    public PendingFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_pending , container , false);

        return inflater.inflate(R.layout.fragment_pending, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        month = (TextView)view.findViewById(R.id.month);
        ll_click=view.findViewById(R.id.click_call);
        name = view.findViewById(R.id.name);
        name2 = view.findViewById(R.id.name2);
        name3 = view.findViewById( R.id.name3);
        sessionManager = new SessionManager(view.getContext());
        if(sessionManager.isLoggedIn().equals("Manufacturer")) {
            name.setText("Prakash Footwear");
            name2.setText("Angel Cosmetics");
            name3.setText("Kq Beauty Crown");
        }else {

            name.setText("Nike INC");
            name2.setText("Fast Track");
            name3.setText("Lakme Cosmetics");
        }
        //picDate();

     /*   mTextMessage = (TextView) view.findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) view.findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);*/

        curdate = (TextView)view.findViewById(R.id.curdate);
        Date c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = df.format(c);
        curdate.setText(formattedDate);

        //---------------------------------

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String currentTime = sdf.format(new Date());
        curtime = (TextView)view.findViewById(R.id.curtime);
        curtime.setText(currentTime);

        myCalendar = Calendar.getInstance();

        //--------------------------------



        date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };

        ll_click.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent i=new Intent(getContext(), Call_splash_screen.class);
                startActivity(i);
            }
        });

        month.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
//                dateFlage = "1";
//                new DatePickerDialog(getActivity(), date, myCalendar
//                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
//                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
                Intent intent = new Intent(v.getContext() , Calender_Activity.class);
                startActivity(intent);
            }
        });
       if(sessionManager.isLoggedIn().equals("Manufacturer"))
       {
            myListData = new MyListData[] {
                   new MyListData("Prakash Footwear", R.drawable.complogo),
                   new MyListData("Angel Cosmetics", R.drawable.sander),
                   new MyListData("Kq Beauty Crown", R.drawable.complogo),
                   new MyListData(
                           "Anitas Aromatic Solutions", R.drawable.sander),
                   new MyListData(
                           "Calcutta Footwear", R.drawable.complogo),
//                new MyListData("Balkrishna Industries Ltd (BKT)", R.drawable.complogo),
//                new MyListData("Bayer CropScience Ltd", R.drawable.complogo),

           };
           name.setText("Prakash Footwear");
           name2.setText("Angel Cosmetics");
           name3.setText("Kq Beauty Crown");
       }else {
           myListData = new MyListData[] {
                   new MyListData("Nike INC", R.drawable.complogo),
                   new MyListData("Lakme Cosmetics", R.drawable.sander),
                   new MyListData("Fast Track", R.drawable.complogo),
                   new MyListData(
                           "Ansian Paints", R.drawable.sander),
                   new MyListData(
                           "Peter England", R.drawable.complogo),
//                new MyListData("Balkrishna Industries Ltd (BKT)", R.drawable.complogo),
//                new MyListData("Bayer CropScience Ltd", R.drawable.complogo),

           };
           name.setText("Nike INC");
           name2.setText("Fast Track");
           name3.setText("Lakme Cosmetics");
       }


        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.my_recycler_view);
        MyListAdapter adapter = new MyListAdapter(view ,myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
    }

    private void updateLabel() {

        if (dateFlage.equalsIgnoreCase("1")) {
            String myFormat = "dd-MM-yyyy"; //In which you need put here
            SimpleDateFormat sdf = new SimpleDateFormat(myFormat, new Locale("pt", "BR"));
            //   dateInstaUP.setText(sdf.format(myCalendar.getTime()));
            //   dateInstaUP.setTextColor(getResources().getColor(R.color.colorPrimary));
        }
    }

}