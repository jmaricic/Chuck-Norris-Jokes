package com.example.josipmaricic.chucknorrisjoke;

import com.example.josipmaricic.chucknorrisjoke.helper.dialog.JokeDialog;
import com.example.josipmaricic.chucknorrisjoke.module.AppModule;
import com.example.josipmaricic.chucknorrisjoke.ui.JokeActivity;
import com.example.josipmaricic.chucknorrisjoke.ui.JokeListActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by josipmaricic on 10/11/2016.
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    void inject(App app);

    void inject(JokeActivity activity);

    void inject(JokeListActivity activity);

    void inject(JokeDialog dialog);

}
