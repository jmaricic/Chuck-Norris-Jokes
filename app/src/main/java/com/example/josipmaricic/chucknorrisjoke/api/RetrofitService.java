package com.example.josipmaricic.chucknorrisjoke.api;

import com.example.josipmaricic.chucknorrisjoke.data.JokesListResponse;
import com.example.josipmaricic.chucknorrisjoke.data.RandomJokeResponse;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by josipmaricic on 10/11/2016.
 */

public interface RetrofitService {

    @GET("/jokes/random/")
    Observable<RandomJokeResponse> getRandomJoke();

    @GET("/jokes/random/15")
    Observable<JokesListResponse> getRandomJokeList();
}
