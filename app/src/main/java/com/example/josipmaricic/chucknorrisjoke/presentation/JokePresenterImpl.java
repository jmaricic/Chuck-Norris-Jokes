package com.example.josipmaricic.chucknorrisjoke.presentation;

import com.example.josipmaricic.chucknorrisjoke.api.RetrofitService;
import com.example.josipmaricic.chucknorrisjoke.data.JokeData;
import com.example.josipmaricic.chucknorrisjoke.data.JokesListResponse;
import com.example.josipmaricic.chucknorrisjoke.data.RandomJokeResponse;
import com.example.josipmaricic.chucknorrisjoke.view.JokeView;

import java.util.ArrayList;
import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by josipmaricic on 10/11/2016.
 */

public class JokePresenterImpl implements JokePresenter {

    private JokeView mJokeView;
    private RetrofitService mRetrofitService;
    private List<String> mData = new ArrayList<>();
    private String mJoke;

    public JokePresenterImpl(RetrofitService retrofitService) {
        this.mRetrofitService = retrofitService;
    }

    @Override
    public void setView(JokeView view) {
        this.mJokeView = view;
    }

    @Override
    public void getRandomJoke() {
        mJokeView.showProgress();
        mRetrofitService.getRandomJoke()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(bindRandomJokeObserver());
    }

    private Observer<RandomJokeResponse> bindRandomJokeObserver() {
        return new Observer<RandomJokeResponse>() {
            @Override
            public void onCompleted() {
                mJokeView.hideProgress();
                mJokeView.showJoke(mJoke);
            }

            @Override
            public void onError(Throwable e) {
                mJokeView.hideProgress();
                mJokeView.showError(e.getMessage());
            }

            @Override
            public void onNext(RandomJokeResponse randomJokeResponse) {
                if (randomJokeResponse != null) {
                    mJokeView.hideProgress();
                    mJoke = randomJokeResponse.getJokeData().getJoke();
                }
            }
        };
    }

    @Override
    public void getListOfJokes() {
        mJokeView.showProgress();
        mRetrofitService.getRandomJokeList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(bindJokeListObserver());
    }

    private Observer<JokesListResponse> bindJokeListObserver() {
        return new Observer<JokesListResponse>() {
            @Override
            public void onCompleted() {
                mJokeView.hideProgress();
                mJokeView.showJokes(mData);
            }

            @Override
            public void onError(Throwable e) {
                mJokeView.hideProgress();
                mJokeView.showError(e.getMessage());
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
