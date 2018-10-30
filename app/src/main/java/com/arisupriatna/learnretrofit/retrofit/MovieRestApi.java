package com.arisupriatna.learnretrofit.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieRestApi {
    @GET("articles")
    Call<MovieAPI> getMovies();
}
