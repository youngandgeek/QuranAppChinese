package com.example.quranapp.network;

import com.example.quranapp.SurahDetails;
import com.example.quranapp.response.SurahDetailResponse;
import com.example.quranapp.response.SurahResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface JsonPlaceHolderApi {
    //Get request method and pass the url endpoint
        @GET("surah")
    Call<SurahResponse> getSurah();

   //Get all surahDetails from the second request method , pass the url endpoint
     @GET("sura/{language}/{id}")
    Call<SurahDetailResponse>getSurahDetail(@Path("language") String lan,
                                            @Path("id")int surahId);
}
