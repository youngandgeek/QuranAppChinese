package com.example.quranapp.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.quranapp.repository.SurahDetailRepo;
import com.example.quranapp.response.SurahDetailResponse;

import java.io.Closeable;

public class SurahDetailViewModel extends ViewModel {
    public SurahDetailRepo surahDetailRepo;

    public SurahDetailViewModel() {
 surahDetailRepo=new SurahDetailRepo();

    }
    public LiveData<SurahDetailResponse> getSurahDetail(String lan,int id){
        return surahDetailRepo.getSurahDetail(lan, id);
    }
}
