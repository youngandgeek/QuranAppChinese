package com.example.quranapp.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.quranapp.network.Api;
import com.example.quranapp.network.JsonPlaceHolderApi;
import com.example.quranapp.response.SurahResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SurahRepo {
    //initialize an instance of JsonPlaceHolder Class and create an empty constructor
    private JsonPlaceHolderApi jsonPlaceHolderApi;

    public SurahRepo() {
        jsonPlaceHolderApi = Api.getRetrofit().create(JsonPlaceHolderApi.class);
    }

    public LiveData<SurahResponse> getSurah() {
        MutableLiveData<SurahResponse> data = new MutableLiveData<>();
        jsonPlaceHolderApi.getSurah().enqueue(new Callback<SurahResponse>() {
            @Override
            public void onResponse(Call<SurahResponse> call, Response<SurahResponse> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<SurahResponse> call, Throwable t) {
                Log.d("TAG", "Response = " + t.toString());
                data.setValue(null);
            }
        });
        return data;
    }

    }

