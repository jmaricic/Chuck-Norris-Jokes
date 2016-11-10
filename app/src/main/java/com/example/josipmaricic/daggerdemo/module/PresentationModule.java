package com.example.josipmaricic.daggerdemo.module;

import com.example.josipmaricic.daggerdemo.api.RetrofitService;
import com.example.josipmaricic.daggerdemo.presentation.JokePresenter;
import com.example.josipmaricic.daggerdemo.presentation.JokePresenterImpl;

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
}
