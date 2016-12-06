package com.example.josipmaricic.chucknorrisjoke.mvp.presentation;

import com.example.josipmaricic.chucknorrisjoke.base.BasePresenter;
import com.example.josipmaricic.chucknorrisjoke.data.JokesListResponse;
import com.example.josipmaricic.chucknorrisjoke.mvp.view.JokeListView;

/**
 * Created by Josip on 14.11.2016..
 */

public interface JokeListPresenter extends BasePresenter<JokeListView> {

    void getListOfJokes();
}
