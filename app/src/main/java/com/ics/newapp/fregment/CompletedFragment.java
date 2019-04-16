package com.ics.newapp.fregment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.ics.newapp.InvoceVActivity;
import com.ics.newapp.Navigation;
import com.ics.newapp.R;


public class CompletedFragment extends Fragment {

//    public CompletedFragment() {
//        // Required empty public constructor
//    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_completed, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {


        Button ll=view.findViewById(R.id.bt_comp);
        ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), InvoceVActivity.class);
                startActivity(intent);
            }
        });
        super.onViewCreated(view, savedInstanceState);

    }
}
