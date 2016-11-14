package com.example.josipmaricic.daggerdemo.presentation;

import com.example.josipmaricic.daggerdemo.base.Presenter;
import com.example.josipmaricic.daggerdemo.view.JokeListView;

/**
 * Created by Josip on 14.11.2016..
 */

public interface JokeListPresenter extends Presenter<JokeListView> {

    void getListOfJokes();
}
