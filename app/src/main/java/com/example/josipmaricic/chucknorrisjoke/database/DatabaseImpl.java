package com.example.josipmaricic.chucknorrisjoke.database;

import com.example.josipmaricic.chucknorrisjoke.App;
import com.example.josipmaricic.chucknorrisjoke.database.model.Joke;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import io.realm.RealmResults;

/**
 * Created by Josip on 21.11.2016..
 */

public class DatabaseImpl implements DatabaseInterface {

    public DatabaseImpl() {
        Realm.setDefaultConfiguration(new RealmConfiguration.Builder(App.get()).build());
    }

    @Override
    public void addJoke(String joke) {
        if (joke != null) {
            Realm instance = Realm.getDefaultInstance();
            instance.beginTransaction();
            Joke joke1 = new Joke();
            joke1.setJokeText(joke);
            instance.copyToRealmOrUpdate(joke1);
            instance.commitTransaction();
        }
    }

    @Override
    public RealmResults<Joke> getJoke() {
        Realm instance = Realm.getDefaultInstance();
        return instance.where(Joke.class).findAll();
    }

    @Override
    public void removeJoke(String joke) {
        Realm instance = Realm.getDefaultInstance();
        Joke joke1 = instance.where(Joke.class).contains("jokeText", joke).findFirst();
        removeObjectFromRealm(joke1, instance);
    }

    private void removeObjectFromRealm(RealmObject object, Realm instance) {
        if (instance != null) {
            instance.beginTransaction();
            object.deleteFromRealm();
            instance.commitTransaction();
        }
    }
}
