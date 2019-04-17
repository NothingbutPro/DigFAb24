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
import android.widget.Toast;

import com.ics.newapp.OrderTracking;
import com.ics.newapp.R;
import com.ics.newapp.Tracked_Order;

public class Order_Taken extends Fragment {
    LinearLayout fullorder;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.order_taken , container ,false);
        fullorder = view.findViewById(R.id.fullorder);
        fullorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "xfsadf", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity() , Tracked_Order.class);
                startActivity(intent);
            }
        });
        return view;
//        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
