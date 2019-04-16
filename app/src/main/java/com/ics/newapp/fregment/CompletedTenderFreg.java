package com.ics.newapp.fregment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ics.newapp.R;
import com.ics.newapp.adapter.CompleteTenAdapter;
import com.ics.newapp.adapter.MoviesAdapter;
import com.ics.newapp.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class CompletedTenderFreg extends Fragment {
    private List<Movie> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private CompleteTenAdapter completeTenAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_completed_tender_freg, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        completeTenAdapter = new CompleteTenAdapter(movieList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(completeTenAdapter);

        prepareMovieData();
    }

    private void prepareMovieData() {
        Movie movie = new Movie("Lenovo Laptop", "10 laptop", "20000");
        movieList.add(movie);

        movie = new Movie("Hp Laptop", "10 laptop", "2015");
        movieList.add(movie);

        movie = new Movie("Dell Laptop", "15 laptop", "6000");
        movieList.add(movie);

        completeTenAdapter.notifyDataSetChanged();
    }

}
