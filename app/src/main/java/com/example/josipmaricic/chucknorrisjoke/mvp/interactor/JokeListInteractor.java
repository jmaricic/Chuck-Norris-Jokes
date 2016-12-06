package com.example.josipmaricic.chucknorrisjoke.mvp.interactor;

import com.example.josipmaricic.chucknorrisjoke.data.JokesListResponse;

import rx.Observable;

/**
 * Created by Josip on 6.12.2016..
 */

public interface JokeListInteractor {

    Observable<JokesListResponse> getListOfJokes();
}
