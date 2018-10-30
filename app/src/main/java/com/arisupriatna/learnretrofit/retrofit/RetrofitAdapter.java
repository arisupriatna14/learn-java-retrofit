package com.arisupriatna.learnretrofit.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitAdapter {
    public Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("http://blog-api.arisupriatna.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
