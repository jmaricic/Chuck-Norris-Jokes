package com.example.josipmaricic.chucknorrisjoke.mvp.view;

import com.example.josipmaricic.chucknorrisjoke.base.BaseView;

import java.util.List;

/**
 * Created by josipmaricic on 10/11/2016.
 */

public interface JokeView extends BaseView {

    void showJoke(String joke);

    void showError(String message);

    void showJokes(List<String> mData);

    void openFavoriteJokes();
}
