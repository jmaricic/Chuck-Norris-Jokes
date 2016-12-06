package com.example.josipmaricic.chucknorrisjoke.mvp.presentation;

import com.example.josipmaricic.chucknorrisjoke.base.BasePresenter;
import com.example.josipmaricic.chucknorrisjoke.data.JokesListResponse;
import com.example.josipmaricic.chucknorrisjoke.data.RandomJokeResponse;
import com.example.josipmaricic.chucknorrisjoke.mvp.view.JokeView;

/**
 * Created by josipmaricic on 10/11/2016.
 */

public interface JokePresenter extends BasePresenter<JokeView> {

    void getRandomJoke();

    void getListOfJokes();

    void seeMyFavoriteJokes();
}
