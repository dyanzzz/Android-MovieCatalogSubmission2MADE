package com.submission.moviecatalogsubmission2made.fragment;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.submission.moviecatalogsubmission2made.R;
import com.submission.moviecatalogsubmission2made.adapter.CardMovieAdapter;
import com.submission.moviecatalogsubmission2made.model.Movie;
import com.submission.moviecatalogsubmission2made.model.MovieData;

import java.util.ArrayList;

public class TVShowFragment extends Fragment {

    private RecyclerView rvMovies;
    private ArrayList<Movie> list = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        rvMovies = view.findViewById(R.id.rv_movie);
        rvMovies.setHasFixedSize(true);

        list.addAll(MovieData.getListData("TVShow"));
        showRecyclerList();

        return view;
    }

    private void showRecyclerList(){
        rvMovies.setLayoutManager(new LinearLayoutManager(getContext()));
        CardMovieAdapter cardMovieAdapter = new CardMovieAdapter(list);
        rvMovies.setAdapter(cardMovieAdapter);

    }
}


