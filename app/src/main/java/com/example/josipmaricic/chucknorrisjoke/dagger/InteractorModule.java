package com.example.josipmaricic.chucknorrisjoke.dagger;

import com.example.josipmaricic.chucknorrisjoke.api.RetrofitService;
import com.example.josipmaricic.chucknorrisjoke.mvp.interactor.JokeInteractor;
import com.example.josipmaricic.chucknorrisjoke.mvp.interactor.JokeInteractorImpl;
import com.example.josipmaricic.chucknorrisjoke.mvp.interactor.JokeListInteractor;
import com.example.josipmaricic.chucknorrisjoke.mvp.interactor.JokeListInteractorImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Josip on 6.12.2016..
 */
@Module(includes = {NetworkModule.class})
public class InteractorModule {

    @Provides
    JokeInteractor provideJokeInteractor(RetrofitService service) {
        return new JokeInteractorImpl(service);
    }

    @Provides
    JokeListInteractor provideJokeListInteractor(RetrofitService service) {
        return new JokeListInteractorImpl(service);
    }
}
