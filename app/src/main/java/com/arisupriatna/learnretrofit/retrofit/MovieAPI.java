package com.arisupriatna.learnretrofit.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieAPI {
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("resultArr")
    @Expose
    private List<MovieList> resultArr = null;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<MovieList> getResultArr() {
        return resultArr;
    }

    public void setResultArr(List<MovieList> resultArr) {
        this.resultArr = resultArr;
    }
}