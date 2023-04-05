package com.example.quranapp.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {
    //implementing get request
    //https://alquran.cloud/api
    public static String BASE_URL = "http://api.alquran.cloud/v1/";
    //retrofit instance
    private static Retrofit retrofit;

    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    //convert the json with GsonConverter
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
//get surah Details ->Display all surah
//all languages qur'an https://quranenc.com/en/home

    public static Retrofit getInstance() {
        if (retrofit != null) {
           retrofit = null;
        }
           retrofit = new Retrofit.Builder()
                .baseUrl("https://quranenc.com/api/v1/translation/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
