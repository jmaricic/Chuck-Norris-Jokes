package com.example.josipmaricic.chucknorrisjoke.presentation;

import com.example.josipmaricic.chucknorrisjoke.base.Presenter;
import com.example.josipmaricic.chucknorrisjoke.view.JokeView;

/**
 * Created by josipmaricic on 10/11/2016.
 */

public interface JokePresenter extends Presenter<JokeView> {

    void getRandomJoke();

    void getListOfJokes();
}
