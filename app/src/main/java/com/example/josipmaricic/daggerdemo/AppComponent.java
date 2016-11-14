package com.example.josipmaricic.daggerdemo;

import com.example.josipmaricic.daggerdemo.helper.dialog.JokeDialog;
import com.example.josipmaricic.daggerdemo.helper.image.ImageHelperInterface;
import com.example.josipmaricic.daggerdemo.module.AppModule;
import com.example.josipmaricic.daggerdemo.presentation.JokePresenter;
import com.example.josipmaricic.daggerdemo.ui.JokeActivity;
import com.example.josipmaricic.daggerdemo.ui.JokeListActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by josipmaricic on 10/11/2016.
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    JokePresenter getPresenter();

    ImageHelperInterface getImageHelper();

    void inject(App app);

    void inject(JokeActivity activity);

    void inject(JokeListActivity activity);

    void inject(JokeDialog dialog);

}
