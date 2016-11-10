package com.example.josipmaricic.daggerdemo.module;

import com.example.josipmaricic.daggerdemo.App;
import com.example.josipmaricic.daggerdemo.module.NetworkModule;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by josipmaricic on 10/11/2016.
 */
@Module(includes = PresentationModule.class)
public class AppModule {
    private App app;

    public AppModule(App app) {
        this.app = app;
    }

    @Provides
    @Singleton
    public App provideApp() {
        return app;
    }
}
