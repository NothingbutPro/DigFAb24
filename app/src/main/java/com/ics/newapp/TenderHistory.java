package com.ics.newapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.ics.newapp.adapter.MoviesAdapter;
import com.ics.newapp.model.Movie;

import java.util.ArrayList;
import java.util.List;


public class TenderHistory extends AppCompatActivity {

    Toolbar toolbar_billHistory;
    private List<Movie> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MoviesAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tender_history);

        TextView newtender=(TextView)findViewById(R.id.newtender);

        toolbar_billHistory = (Toolbar)findViewById(R.id.toolbar_billHistory);

        toolbar_billHistory = (Toolbar) findViewById(R.id.toolbar_billHistory);
        toolbar_billHistory.setNavigationIcon(R.drawable.arrow);
        toolbar_billHistory.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //   stopActivityTask();
                onBackPressed();
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new MoviesAdapter(movieList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        newtender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TenderHistory.this,New_Tender_Buyer.class);
                startActivity(intent);
            }
        });


        prepareMovieData();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private void prepareMovieData() {
        Movie movie = new Movie("Arun Enterprises", "10 laptop" ,"20000");
        movieList.add(movie);

        movie = new Movie("Mukesh Hardware", "Animation, Kids & Family", "2015");
        movieList.add(movie);

        movie = new Movie("Namo Foods", "Sweets 10kg", "6000");
        movieList.add(movie);

        movie = new Movie("Airtel Company", "1000 Sim Card", "9170");
        movieList.add(movie);

        movie = new Movie("The Martian", "2 Mobile Phone", "15000");
        movieList.add(movie);

        movie = new Movie("Raja Jwelers", "Neck Haar", "90007");
        movieList.add(movie);

        movie = new Movie("Jio Mobile", "5 Dth", "2009");
        movieList.add(movie);

        movie = new Movie("Star Trek", "Science Fiction", "2009");
        movieList.add(movie);

        movie = new Movie("The LEGO Movie", "Animation", "2014");
        movieList.add(movie);

        movie = new Movie("Iron Man", "Action & Adventure", "2008");
        movieList.add(movie);

        movie = new Movie("Aliens", "Science Fiction", "1986");
        movieList.add(movie);



        mAdapter.notifyDataSetChanged();
    }
}
