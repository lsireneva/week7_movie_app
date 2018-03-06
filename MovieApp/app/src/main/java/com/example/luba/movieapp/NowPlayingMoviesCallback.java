package com.example.luba.movieapp;

import java.util.ArrayList;

/**
 * Created by luba on 3/5/18.
 */

public interface NowPlayingMoviesCallback {

    void onSuccess(ArrayList<Movie> movies);

    void onError(Error error);
}
