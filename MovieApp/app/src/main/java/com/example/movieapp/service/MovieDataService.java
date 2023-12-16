package com.example.movieapp.service;

import com.example.movieapp.model.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieDataService {
//    https://api.themoviedb.org/3/movie/popular?api_key=9a34f92ed043f13a79e31f5631bb9eeb
    @GET("movie/popular")
    Call<Result> getPopularMovies(@Query("api_key") String apiKey);
}
