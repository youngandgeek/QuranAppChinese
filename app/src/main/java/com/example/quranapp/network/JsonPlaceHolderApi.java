package com.example.quranapp.network;

import com.example.quranapp.response.SurahResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {
    //Get request method and pass the url endpoint
        @GET("surah")
    Call<SurahResponse> getSurah();
}
