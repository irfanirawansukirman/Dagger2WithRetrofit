package com.iriras.androiddagger2withretrofit.dagger.module;

import android.app.Application;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by irfan on 02/04/17.
 */

@Module
public class NetModule {
    private String BASE_URL;

    public NetModule(String BASE_URL) {
        this.BASE_URL = BASE_URL;
    }

    @Provides
    @Singleton
    Cache provideHttpCache(Application mApplication) {
        int mCacheSize = 10 * 1024 * 1024;
        Cache mCache = new Cache(mApplication.getCacheDir(), mCacheSize);
        return mCache;
    }

    @Provides
    @Singleton
    Gson provideGson() {
        GsonBuilder mGsonBuilder = new GsonBuilder();
        mGsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return mGsonBuilder.create();
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(Cache mCache) {
        OkHttpClient.Builder mBuilder = new OkHttpClient.Builder();
        mBuilder.cache(mCache);
        return mBuilder.build();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(Gson mGson,
                             OkHttpClient mOkHttpClient) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(mGson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .client(mOkHttpClient)
                .build();
    }
}
