package com.example.josipmaricic.chucknorrisjoke.mvp.interactor;


import com.example.josipmaricic.chucknorrisjoke.data.JokesListResponse;
import com.example.josipmaricic.chucknorrisjoke.data.RandomJokeResponse;

import rx.Observable;

/**
 * Created by Josip on 6.12.2016..
 */

public interface JokeInteractor {

    Observable<RandomJokeResponse> getRandomJoke();

    Observable<JokesListResponse> getListOfJokes();
}
