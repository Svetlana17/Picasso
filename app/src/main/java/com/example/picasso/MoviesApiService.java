package com.example.picasso;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MoviesApiService {
    @GET("movie/popular")
    Call<ResponseModel> getPopularMovies(@Query("api_key") String api_key);

}