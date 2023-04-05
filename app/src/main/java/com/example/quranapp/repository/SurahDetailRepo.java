package com.example.quranapp.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.quranapp.network.Api;
import com.example.quranapp.network.JsonPlaceHolderApi;
import com.example.quranapp.response.SurahDetailResponse;
import com.example.quranapp.response.SurahResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SurahDetailRepo {
    //initialize an instance of JsonPlaceHolder Class and create an empty constructor
    private JsonPlaceHolderApi jsonPlaceHolderApi;

    public SurahDetailRepo() {
        jsonPlaceHolderApi = Api.getInstance().create(JsonPlaceHolderApi.class);
    }

//call get surah detail method from jsonPlaceHolderApi interface and pass the 2 parameter
    public LiveData<SurahDetailResponse> getSurahDetail(String lan,int id) {
        MutableLiveData<SurahDetailResponse> data = new MutableLiveData<>();
        jsonPlaceHolderApi.getSurahDetail(lan,id).enqueue(new Callback<SurahDetailResponse>() {

            @Override
            public void onResponse(Call<SurahDetailResponse> call, Response<SurahDetailResponse> response) {
                data.setValue(response.body());

            }

            @Override
            public void onFailure(Call<SurahDetailResponse> call, Throwable t) {
                Log.d("TAG", "Response = " + t.toString());
                data.setValue(null);
            }
        });
        return data;
    }
}
