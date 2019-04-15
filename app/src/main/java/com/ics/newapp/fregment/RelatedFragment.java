package com.ics.newapp.fregment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ics.newapp.R;
import com.ics.newapp.adapter.MyListAdapter;
import com.ics.newapp.model.MyListData;


public class RelatedFragment extends Fragment {
   // private RecyclerView my_recycler_view;

    public RelatedFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_related, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MyListData[] myListData = new MyListData[] {
                new MyListData("Asian Umbrella Manufacturers", R.drawable.complogo),
                new MyListData("Aarti Industries Ltd", R.drawable.sander),
                new MyListData("Abbott India Ltd", R.drawable.complogo),
                new MyListData(
                        "ACC Ltd", R.drawable.sander),
                new MyListData(
                        "Ajanta Pharma Ltd", R.drawable.complogo),
                new MyListData("Balkrishna Industries Ltd (BKT)", R.drawable.complogo),
                new MyListData("Bayer CropScience Ltd", R.drawable.complogo),

        };

        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.my_recycler_view);
        MyListAdapter adapter = new MyListAdapter(myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
    }
}
