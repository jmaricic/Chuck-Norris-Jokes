package com.example.josipmaricic.chucknorrisjoke.mvp.interactor;

import com.example.josipmaricic.chucknorrisjoke.api.RetrofitService;
import com.example.josipmaricic.chucknorrisjoke.data.JokesListResponse;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Josip on 6.12.2016..
 */

public class JokeListInteractorImpl implements JokeListInteractor {

    private RetrofitService retrofitService;

    public JokeListInteractorImpl(RetrofitService service) {
        this.retrofitService = service;
    }

    @Override
    public Observable<JokesListResponse> getListOfJokes() {
        return retrofitService.getRandomJokeList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
