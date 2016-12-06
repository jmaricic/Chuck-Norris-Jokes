package com.example.josipmaricic.chucknorrisjoke.mvp.interactor;

import com.example.josipmaricic.chucknorrisjoke.api.RetrofitService;

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
    public Observable getRandomJoke() {
        return retrofitService.getRandomJoke()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
//                .subscribe(new Observer<RandomJokeResponse>() {
//                    @Override
//                    public void onCompleted() {
//                        presenter.onRandomJokeCompleted();
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        presenter.onError(e.getMessage());
//                    }
//
//                    @Override
//                    public void onNext(RandomJokeResponse randomJokeResponse) {
//                        presenter.onNextRandomJoke(randomJokeResponse);
//                    }
//                });
    }

    @Override
    public Observable getListOfJokes() {
        return retrofitService.getRandomJokeList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
//                .subscribe(new Observer<JokesListResponse>() {
//                    @Override
//                    public void onCompleted() {
//                        presenter.onJokeListCompleted();
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        presenter.onError(e.getMessage());
//                    }
//
//                    @Override
//                    public void onNext(JokesListResponse jokesListResponse) {
//                        presenter.onNextJokeList(joke);
//                    }
//                });
    }
}
