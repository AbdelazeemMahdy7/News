package com.example.news.Network;

import com.example.news.Models.NewsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Apis {



    @GET("/v2/top-headlines?apiKey=d09861d52847456e8aebd89f8ba31c8a")
    Call<NewsResponse> getNews(@Query("country")String country,
                               @Query("category")String category);
}
