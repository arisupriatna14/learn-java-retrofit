package com.arisupriatna.learnretrofit.retrofit;

import com.google.gson.annotations.Expose;

public class Result {
    @Expose
    private Object result;

    @Expose
    private String message;

    public Object getResult() {
        return result;
    }

    public String getMessage() {
        return message;
    }
}
