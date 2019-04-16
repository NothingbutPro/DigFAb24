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
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ics.newapp.R;
import com.ics.newapp.adapter.MoviesAdapter;
import com.ics.newapp.model.Movie;

import java.util.ArrayList;
import java.util.List;


public class PendingTenderFreg extends Fragment {
  //  Toolbar toolbar_billHistory;
    private List<Movie> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MoviesAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pending_tender_freg, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        mAdapter = new MoviesAdapter(movieList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareMovieData();
    }

    private void prepareMovieData() {
        Movie movie = new Movie("Lenovo Laptop", "10 laptop", "20000");
        movieList.add(movie);

        movie = new Movie("Hp Laptop", "10 laptop", "2015");
        movieList.add(movie);

        movie = new Movie("Dell Laptop", "15 laptop", "6000");
        movieList.add(movie);

        movie = new Movie("Apple Laptop", "5 Laptop", "9170");
        movieList.add(movie);

        movie = new Movie("Lenovo Laptop", "5 Laptop", "15000");
        movieList.add(movie);

        movie = new Movie("Hp Laptop", "2 Laptop", "90007");
        movieList.add(movie);

        movie = new Movie("Dell Laptop", "5 Laptop", "2009");
        movieList.add(movie);

        movie = new Movie("Apple Laptop", "1 Laptop", "2009");
        movieList.add(movie);

        movie = new Movie("Lenovo Laptop", "6 Laptop", "2014");
        movieList.add(movie);

        movie = new Movie("Hp Laptop", "3 Laptop", "2008");
        movieList.add(movie);

        movie = new Movie("Dell Laptop", "5 Laptop", "1986");
        movieList.add(movie);


        mAdapter.notifyDataSetChanged();
    }

}
