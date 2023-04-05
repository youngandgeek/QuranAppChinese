package com.example.quranapp.response;

import com.example.quranapp.model.Surah;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SurahResponse {

/**get the api data response and save it to the list of a model class
 * json data in an array so we initialize it and pass the surah model class
 */
@SerializedName("data")
    private List<Surah> list;

    public List<Surah> getList() {
        return list;
    }

    public void setList(List<Surah> list) {
        this.list = list;
    }
}
