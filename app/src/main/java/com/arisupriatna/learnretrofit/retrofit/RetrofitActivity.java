package com.arisupriatna.learnretrofit.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.arisupriatna.learnretrofit.R;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitActivity extends AppCompatActivity {

    private Gson gson;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        resultTextView = (TextView) findViewById(R.id.result_text_view);
        gson = new Gson();
        RetrofitAdapter retrofitAdapter = new RetrofitAdapter();
        final MovieRestApi movieRestApi = retrofitAdapter
                .getRetrofit()
                .create(MovieRestApi.class);
        getMovies(movieRestApi);
    }

    private void getMovies(MovieRestApi movieRestApi) {
        resultTextView.setText("Loading. Please wait...");
        movieRestApi.getMovies()
                .enqueue(new Callback<MovieAPI>() {
                    @Override
                    public void onResponse(Call<MovieAPI> call, Response<MovieAPI> response) {
                        if (response.isSuccessful()) {
                            JsonArray jsonArray = gson.toJsonTree(response.body().getResultArr()).getAsJsonArray();
                            Type moviesType = new TypeToken<ArrayList<MovieList>>() {
                            }.getType();
                            List<MovieList> movies = gson.fromJson(jsonArray, moviesType);
                            for (MovieList movie : movies) {
                                resultTextView.setText(resultTextView.getText().toString() + "\n\n" + movie.toString());
                            }
                        } else {
                            try {
                                resultTextView.setText(resultTextView.getText().toString() + "\n\nError try:" + response.errorBody().string());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<MovieAPI> call, Throwable t) {
                        resultTextView.setText(resultTextView.getText().toString() + "\n\nError onFailure: " + t.getMessage());
                    }
                });
    }
}