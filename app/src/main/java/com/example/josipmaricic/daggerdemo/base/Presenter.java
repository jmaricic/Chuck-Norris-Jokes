package com.example.josipmaricic.daggerdemo.base;

/**
 * Created by josipmaricic on 10/11/2016.
 */

public interface Presenter<T> {

    void setView(T view);
}
