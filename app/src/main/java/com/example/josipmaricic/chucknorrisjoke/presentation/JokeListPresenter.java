package com.example.josipmaricic.chucknorrisjoke.presentation;

import com.example.josipmaricic.chucknorrisjoke.base.Presenter;
import com.example.josipmaricic.chucknorrisjoke.view.JokeListView;

/**
 * Created by Josip on 14.11.2016..
 */

public interface JokeListPresenter extends Presenter<JokeListView> {

    void getListOfJokes();
}
