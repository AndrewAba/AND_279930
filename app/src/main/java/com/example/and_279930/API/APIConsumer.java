package com.example.and_279930.API;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIConsumer {

    private static final String BASE_URL = "http://roll.diceapi.com";
    private static APIConsumer instance;
    private Retrofit retrofit;

    public static APIConsumer getInstance() {
        if (instance == null) {
            instance = new APIConsumer();
        }
        return instance;
    }

    private APIConsumer() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        Gson gson = new GsonBuilder()
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    public Retrofit getRetrofitClient() {
        return retrofit;
    }
}
