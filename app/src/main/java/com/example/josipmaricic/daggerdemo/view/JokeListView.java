package com.example.josipmaricic.daggerdemo.view;

import com.example.josipmaricic.daggerdemo.base.BaseView;

import java.util.List;

/**
 * Created by Josip on 14.11.2016..
 */

public interface JokeListView extends BaseView {

    void showError(String message);

    void showJokes(List<String> mData);
}
