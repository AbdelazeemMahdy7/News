package com.example.news;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.news.Network.Apis;
import com.example.news.Models.NewsResponse;
import com.example.news.Network.RetrofitClint;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=d09861d52847456e8aebd89f8ba31c8a
//baseUrl://https://newsapi.org
//EndPoint:/v2/top-headlines?country=us&category=business&apiKey=d09861d52847456e8aebd89f8ba31c8a
public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    NewsAdapter newsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.rc_news);


//        Retrofit retrofit= new Retrofit.Builder()
//                .baseUrl("https://newsapi.org")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();

//        Apis apis = RetrofitClint.getInstance().create(Apis.class);
        RetrofitClint.getInstance().getNews( "eg","science")
                .enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                if (response.isSuccessful())
                    System.out.println(response.body().getArticles().size());
                newsAdapter = new NewsAdapter(response.body().getArticles());
                recyclerView.setAdapter(newsAdapter);
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {
                System.out.println(t.getLocalizedMessage());

            }
        });
    }
    void save(){
        SharedPreferences preferences=getSharedPreferences("user",MODE_PRIVATE);
        preferences.edit().putString("token","erhBaeB2dbha5eh5ahbaeh4").apply();
    }
}