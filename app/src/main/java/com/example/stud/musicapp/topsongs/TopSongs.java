package com.example.stud.musicapp.topsongs;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.stud.musicapp.R;
import com.example.stud.musicapp.api.ApiService;
import com.example.stud.musicapp.api.TrendingList;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TopSongs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_songs);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Call<TrendingList> trendingListCall = ApiService. getService ().getTrendingList( "us" ,
                "itunes" , "singles" );
        trendingListCall.enqueue( new Callback<TrendingList>() {
            @Override
            public void onResponse( @NonNull Call<TrendingList> call, @NonNull
                    Response<TrendingList> response) {
                TrendingList trendingList = response.body();
                Log. d ( "TAG" , new Gson().toJson(trendingList));
            }

            @Override
            public void onFailure(@NonNull Call<TrendingList> call, Throwable t) {
                Toast. makeText (TopSongs. this , "Blad pobierania danych: " +
                        t.getLocalizedMessage(), Toast. LENGTH_SHORT ).show();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


}
