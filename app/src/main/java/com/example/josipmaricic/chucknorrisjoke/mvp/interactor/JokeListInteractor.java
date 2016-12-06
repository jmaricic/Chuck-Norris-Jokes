package com.example.josipmaricic.chucknorrisjoke.mvp.interactor;

import rx.Observable;

/**
 * Created by Josip on 6.12.2016..
 */

public interface JokeListInteractor {

    Observable getListOfJokes();
}
