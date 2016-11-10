package com.example.josipmaricic.daggerdemo.api;

import com.example.josipmaricic.daggerdemo.data.JokesResponse;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by josipmaricic on 10/11/2016.
 */

public interface RetrofitService {

    @GET("/jokes/random/")
    Observable<JokesResponse> getRandomJoke();
}
