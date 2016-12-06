package com.example.josipmaricic.chucknorrisjoke.dagger;

import com.example.josipmaricic.chucknorrisjoke.mvp.interactor.JokeInteractor;
import com.example.josipmaricic.chucknorrisjoke.mvp.interactor.JokeListInteractor;
import com.example.josipmaricic.chucknorrisjoke.mvp.presentation.JokeListPresenter;
import com.example.josipmaricic.chucknorrisjoke.mvp.presentation.JokeListPresenterImpl;
import com.example.josipmaricic.chucknorrisjoke.mvp.presentation.JokePresenter;
import com.example.josipmaricic.chucknorrisjoke.mvp.presentation.JokePresenterImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by josipmaricic on 10/11/2016.
 */
@Module(includes = InteractorModule.class)
public class PresentationModule {

    @Provides
    JokePresenter providePresenter(JokeInteractor jokeInteractor) {
        return new JokePresenterImpl(jokeInteractor);
    }

    @Provides
    JokeListPresenter provideJokeListPresenter(JokeListInteractor jokeListInteractor) {
        return new JokeListPresenterImpl(jokeListInteractor);
    }
}
