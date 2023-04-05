package com.example.quranapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.quranapp.repository.SurahRepo;
import com.example.quranapp.response.SurahResponse;

public class SurahViewModel extends ViewModel {
    private SurahRepo surahRepo;

public SurahViewModel() {
        surahRepo=new SurahRepo();
    }
public LiveData<SurahResponse>getSurah (){
        return surahRepo.getSurah();
    }
}
