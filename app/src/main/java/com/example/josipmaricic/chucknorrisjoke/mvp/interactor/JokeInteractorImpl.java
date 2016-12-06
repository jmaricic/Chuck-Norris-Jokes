package com.example.josipmaricic.chucknorrisjoke.mvp.interactor;

import com.example.josipmaricic.chucknorrisjoke.api.RetrofitService;
import com.example.josipmaricic.chucknorrisjoke.data.JokesListResponse;
import com.example.josipmaricic.chucknorrisjoke.data.RandomJokeResponse;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Josip on 6.12.2016..
 */

public class JokeInteractorImpl implements JokeInteractor {

    private RetrofitService retrofitService;

    public JokeInteractorImpl(RetrofitService service) {
        this.retrofitService = service;
    }

    @Override
    public Observable<RandomJokeResponse> getRandomJoke() {
        return retrofitService.getRandomJoke()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<JokesListResponse> getListOfJokes() {
        return retrofitService.getRandomJokeList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
