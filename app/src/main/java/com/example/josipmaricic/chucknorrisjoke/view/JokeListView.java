package com.example.josipmaricic.chucknorrisjoke.view;

import com.example.josipmaricic.chucknorrisjoke.base.BaseView;

import java.util.List;

/**
 * Created by Josip on 14.11.2016..
 */

public interface JokeListView extends BaseView {

    void showError(String message);

    void showJokes(List<String> mData);
}
