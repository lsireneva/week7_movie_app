package com.example.luba.movieapp;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Movie> moviesList;
    MovieAdapter movieAdapter;
    ListView lvItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvItems = (ListView) findViewById(R.id.lvMovies);
        moviesList = new ArrayList<>();
        movieAdapter = new MovieAdapter(this, moviesList);
        lvItems.setAdapter(movieAdapter);

        RestClient.getNowPlayingMovies(new NowPlayingMoviesCallback() {
            @Override
            public void onSuccess(ArrayList<Movie> movies) {
                moviesList.addAll(movies);
                movieAdapter.notifyDataSetChanged();
                //Log.d ("DEBUG", movies.toString());
            }

            @Override
            public void onError(Error error) {
                error.printStackTrace();
            }
        });
    }
}
