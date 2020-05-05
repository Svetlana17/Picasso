package com.example.picasso;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
  // Пример откуда списываем

    RecyclerView recyclerView;
    MovieAdapter movieAdapter;
    RetrofitApi retrofitApi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView= findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        movieAdapter = new MovieAdapter(this);
        recyclerView.setAdapter(movieAdapter);
        getMovie();

    }

    private    void  getMovie(){


        MoviesApiService moviesApiService=retrofitApi.getClient().create(MoviesApiService.class);
        //интерфейс реализован с помощию класса Refrofit  с базовым URL и конвертором

        Call<ResponseModel> call=moviesApiService.getPopularMovies("eb37bafc5fe27ad9ab86a74e72812c06");
        call.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                List<Movie> listmovie=new ArrayList<>();
                listmovie.addAll(response.body().getResults());
                System.out.println(listmovie);
                movieAdapter.setMovieList(listmovie);
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {

            }
        });
    }

}
