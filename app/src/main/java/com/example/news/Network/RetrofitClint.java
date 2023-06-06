package com.example.news.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClint {

    private static Retrofit retrofit;
    public static Apis getInstance(){
        if(retrofit==null){
            retrofit =new Retrofit.Builder()
                    .baseUrl("https://newsapi.org")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit.create(Apis.class);



    }
}
