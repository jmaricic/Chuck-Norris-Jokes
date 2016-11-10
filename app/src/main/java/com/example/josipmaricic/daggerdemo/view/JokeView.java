package com.example.josipmaricic.daggerdemo.view;

import com.example.josipmaricic.daggerdemo.base.BaseView;

/**
 * Created by josipmaricic on 10/11/2016.
 */

public interface JokeView extends BaseView {

    void showJoke(String joke);

    void showError(String message);
}
