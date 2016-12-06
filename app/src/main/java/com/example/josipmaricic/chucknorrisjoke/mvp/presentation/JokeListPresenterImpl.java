package com.example.josipmaricic.chucknorrisjoke.mvp.presentation;

import com.example.josipmaricic.chucknorrisjoke.data.JokeData;
import com.example.josipmaricic.chucknorrisjoke.data.JokesListResponse;
import com.example.josipmaricic.chucknorrisjoke.mvp.interactor.JokeListInteractor;
import com.example.josipmaricic.chucknorrisjoke.mvp.view.JokeListView;

import java.util.ArrayList;
import java.util.List;

import rx.Observer;

/**
 * Created by Josip on 14.11.2016..
 */

public class JokeListPresenterImpl implements JokeListPresenter {

    private JokeListView mJokeListView;
    private List<String> mData = new ArrayList<>();
    private JokeListInteractor jokeInteractor;

    public JokeListPresenterImpl(JokeListInteractor jokeInteractor) {
        this.jokeInteractor = jokeInteractor;
    }

    @Override
    public void setView(JokeListView view) {
        this.mJokeListView = view;
    }

    @Override
    public void getListOfJokes() {
        mJokeListView.showProgress();
        jokeInteractor.getListOfJokes()
        .subscribe(new Observer<JokesListResponse>() {
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
        });
    }

}
