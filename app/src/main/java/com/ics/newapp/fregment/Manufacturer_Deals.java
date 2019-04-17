package com.ics.newapp.fregment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.ics.newapp.ChatActivity;
import com.ics.newapp.R;

public class Manufacturer_Deals extends Fragment {
    LinearLayout manu_fac;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.manufacure, container, false);
        manu_fac = view.findViewById(R.id.manu_fac);
        manu_fac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity() , ChatActivity.class);
                startActivity(intent);
            }
        });
        return view;
//        return inflater.inflate(R.layout.manufacure, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
