package com.example.josipmaricic.chucknorrisjoke.module;

import com.example.josipmaricic.chucknorrisjoke.api.RetrofitService;
import com.example.josipmaricic.chucknorrisjoke.common.Constants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by josipmaricic on 10/11/2016.
 */
@Module
public class NetworkModule {

    @Provides
    @Singleton
    Retrofit provideRetrofit(RxJavaCallAdapterFactory rxJavaCallAdapterFactory, GsonConverterFactory gsonConverterFactory) {
        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addCallAdapterFactory(rxJavaCallAdapterFactory)
                .addConverterFactory(gsonConverterFactory)
                .build();
    }

    @Provides
    RxJavaCallAdapterFactory provideRxJava() {
        return RxJavaCallAdapterFactory.create();
    }

    @Provides
    GsonConverterFactory provideGsonConverter() {
        return GsonConverterFactory.create();
    }

    @Provides
    RetrofitService provideService(Retrofit retrofit) {
        return retrofit.create(RetrofitService.class);
    }
}
