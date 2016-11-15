package com.example.josipmaricic.chucknorrisjoke.module;

import com.example.josipmaricic.chucknorrisjoke.App;
import com.example.josipmaricic.chucknorrisjoke.helper.image.ImageHelper;
import com.example.josipmaricic.chucknorrisjoke.helper.image.ImageHelperInterface;

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

    @Provides
    public ImageHelperInterface provideImageHelper() {
        return new ImageHelper();
    }
}
