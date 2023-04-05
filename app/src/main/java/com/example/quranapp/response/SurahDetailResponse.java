package com.example.quranapp.response;

import com.example.quranapp.model.SurahDetail;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SurahDetailResponse {
    //api data is in json array called result so we initialize it https://quranenc.com/api/v1/translation/sura/english_saheeh/1
    //and pass the surah detail model class as a list
    @SerializedName("result")
    private List<SurahDetail>surahDetailList;

    //getter and setter method


    public List<SurahDetail> getSurahDetailList() {
        return surahDetailList;
    }

    public void setSurahDetailList(List<SurahDetail> surahDetailList) {
        this.surahDetailList = surahDetailList;
    }
}
