package com.example.josipmaricic.daggerdemo.presentation;

import com.example.josipmaricic.daggerdemo.api.RetrofitService;
import com.example.josipmaricic.daggerdemo.data.JokesResponse;
import com.example.josipmaricic.daggerdemo.view.JokeView;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by josipmaricic on 10/11/2016.
 */

public class JokePresenterImpl implements JokePresenter {

    private JokeView jokeView;
    private RetrofitService retrofitService;

    public JokePresenterImpl(RetrofitService retrofitService) {
        this.retrofitService = retrofitService;
    }

    @Override
    public void setView(JokeView view) {
        this.jokeView = view;
    }

    @Override
    public void getRandomJoke() {
        jokeView.showProgress();
        retrofitService.getRandomJoke()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JokesResponse>() {
                    @Override
                    public void onCompleted() {
                        jokeView.hideProgress();
                    }

                    @Override
                    public void onError(Throwable e) {
                        jokeView.hideProgress();
                        jokeView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(JokesResponse jokesResponse) {
                        if (jokesResponse != null) {
                            jokeView.hideProgress();
                            jokeView.showJoke(jokesResponse.getValue().getJoke());
                        }
                    }
                });
    }
}
