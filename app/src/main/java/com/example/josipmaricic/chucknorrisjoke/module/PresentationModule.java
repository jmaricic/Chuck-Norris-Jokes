package com.example.josipmaricic.chucknorrisjoke.module;

import com.example.josipmaricic.chucknorrisjoke.api.RetrofitService;
import com.example.josipmaricic.chucknorrisjoke.presentation.JokeListPresenter;
import com.example.josipmaricic.chucknorrisjoke.presentation.JokeListPresenterImpl;
import com.example.josipmaricic.chucknorrisjoke.presentation.JokePresenter;
import com.example.josipmaricic.chucknorrisjoke.presentation.JokePresenterImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by josipmaricic on 10/11/2016.
 */
@Module(includes = NetworkModule.class)
public class PresentationModule {

    @Provides
    JokePresenter providePresenter(RetrofitService retrofitService) {
        return new JokePresenterImpl(retrofitService);
    }

    @Provides
    JokeListPresenter provideJokeListPresenter(RetrofitService retrofitService) {
        return new JokeListPresenterImpl(retrofitService);
    }
}
