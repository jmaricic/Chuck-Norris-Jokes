package com.example.josipmaricic.daggerdemo.presentation;

import com.example.josipmaricic.daggerdemo.api.RetrofitService;
import com.example.josipmaricic.daggerdemo.data.JokeData;
import com.example.josipmaricic.daggerdemo.data.JokesListResponse;
import com.example.josipmaricic.daggerdemo.view.JokeListView;

import java.util.ArrayList;
import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Josip on 14.11.2016..
 */

public class JokeListPresenterImpl implements JokeListPresenter {

    private JokeListView mJokeListView;
    private RetrofitService mRetrofitService;
    private List<String> mData = new ArrayList<>();

    public JokeListPresenterImpl(RetrofitService mRetrofitService) {
        this.mRetrofitService = mRetrofitService;
    }

    @Override
    public void setView(JokeListView view) {
        this.mJokeListView = view;
    }

    @Override
    public void getListOfJokes() {
        mJokeListView.showProgress();
        mRetrofitService.getRandomJokeList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(bindJokeListObserver());
    }

    private Observer<JokesListResponse> bindJokeListObserver() {
        return new Observer<JokesListResponse>() {
            @Override
            public void onCompleted() {
                mJokeListView.hideProgress();
                mJokeListView.showJokes(mData);
            }

            @Override
            public void onError(Throwable e) {
                mJokeListView.hideProgress();
                mJokeListView.showError(e.getMessage());
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
