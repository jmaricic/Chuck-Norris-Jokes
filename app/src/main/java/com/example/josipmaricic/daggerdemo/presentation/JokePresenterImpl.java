package com.example.josipmaricic.daggerdemo.presentation;

import com.example.josipmaricic.daggerdemo.api.RetrofitService;
import com.example.josipmaricic.daggerdemo.data.JokeData;
import com.example.josipmaricic.daggerdemo.data.JokesListResponse;
import com.example.josipmaricic.daggerdemo.data.RandomJokeResponse;
import com.example.josipmaricic.daggerdemo.view.JokeView;

import java.util.ArrayList;
import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by josipmaricic on 10/11/2016.
 */

public class JokePresenterImpl implements JokePresenter {

    private JokeView jokeView;
    private RetrofitService retrofitService;
    private List<String> mData = new ArrayList<>();

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
                .subscribe(bindRandomJokeObserver());
    }

    private Observer<RandomJokeResponse> bindRandomJokeObserver() {
        return new Observer<RandomJokeResponse>() {
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
            public void onNext(RandomJokeResponse randomJokeResponse) {
                if (randomJokeResponse != null) {
                    jokeView.hideProgress();
                    jokeView.showJoke(randomJokeResponse.getJokeData().getJoke());
                }
            }
        };
    }

    @Override
    public void getListOfJokes() {
        jokeView.showProgress();
        retrofitService.getRandomJokeList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(bindJokeListObserver());
    }

    private Observer<JokesListResponse> bindJokeListObserver() {
        return new Observer<JokesListResponse>() {
            @Override
            public void onCompleted() {
                jokeView.hideProgress();
                jokeView.showJokes(mData);
            }

            @Override
            public void onError(Throwable e) {
                jokeView.hideProgress();
                jokeView.showError(e.getMessage());
            }

            @Override
            public void onNext(JokesListResponse jokesListResponse) {
                if (jokesListResponse != null) {
                    List<JokeData> list = jokesListResponse.getJokeData();
                    mData.clear();
                    for (int i = 0; i < list.size(); i++) {
                        mData.add(list.get(i).getJoke());
                    }
                }
            }
        };
    }
}
