package com.example.josipmaricic.daggerdemo.presentation;

import com.example.josipmaricic.daggerdemo.base.Presenter;
import com.example.josipmaricic.daggerdemo.view.JokeView;

/**
 * Created by josipmaricic on 10/11/2016.
 */

public interface JokePresenter extends Presenter<JokeView> {

    void getRandomJoke();

    void getListOfJokes();
}
