package com.example.josipmaricic.chucknorrisjoke;

import android.app.Application;
import android.support.annotation.NonNull;

import com.example.josipmaricic.chucknorrisjoke.module.AppModule;

/**
 * Created by josipmaricic on 10/11/2016.
 */

public class App extends Application {

    private static App sInstance;
    protected AppComponent component;

    @NonNull
    public static App get() {
        return sInstance;
    }

    protected void setInstance(@NonNull App instance) {
        sInstance = instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        setInstance(this);
        component = provideComponent();
        component.inject(this);
    }

    @NonNull
    protected AppComponent provideComponent() {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }


    @NonNull
    public AppComponent getComponent() {
        return component;
    }
}
