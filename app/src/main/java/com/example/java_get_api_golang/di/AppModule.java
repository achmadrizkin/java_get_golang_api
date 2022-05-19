package com.example.java_get_api_golang.di;

import com.example.java_get_api_golang.network.RetroServiceInterface;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {
    // localhost:3000/v1/products
    String BASE_URL = "http://10.0.2.2:3000/v1/";

    @Singleton
    @Provides
    public Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Singleton
    @Provides
    public RetroServiceInterface getRetroServiceInterface(Retrofit retrofit) {
        return retrofit.create(RetroServiceInterface.class);
    }
}
