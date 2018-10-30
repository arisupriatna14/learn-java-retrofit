package com.arisupriatna.learnretrofit.retrofit;

import com.google.gson.annotations.Expose;

public class ResultList extends Result {
    @Expose
    private String page;

    @Expose
    private String elements;

    public String getPage() {
        return page;
    }

    public String getElements() {
        return elements;
    }
}
