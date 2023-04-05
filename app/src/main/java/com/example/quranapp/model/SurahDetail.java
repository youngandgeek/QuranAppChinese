package com.example.quranapp.model;

import com.google.gson.annotations.SerializedName;

//initialize vars name as json api exactly https://quranenc.com/api/v1/translation/sura/english_saheeh/1
public class SurahDetail {

    @SerializedName("id")
    private int id;
    @SerializedName("sura")
    private int sura;
    @SerializedName("aya")
    private int aya;
    @SerializedName("arabic_text")
    private String arabic_text;
    @SerializedName("translation")
    private String translation;
    @SerializedName("footnotes")
    private String footnotes;


    public SurahDetail(int id, int sura, int aya, String arabic_text, String translation, String footnotes) {
        this.id = id;
        this.sura = sura;
        this.aya = aya;
        this.arabic_text = arabic_text;
        this.translation = translation;
        this.footnotes = footnotes;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSura(int sura) {
        this.sura = sura;
    }

    public void setAya(int aya) {
        this.aya = aya;
    }

    public void setArabic_text(String arabic_text) {
        this.arabic_text = arabic_text;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public void setFootnotes(String footnotes) {
        this.footnotes = footnotes;
    }

    public int getId() {
        return id;
    }

    public int getSura() {
        return sura;
    }

    public int getAya() {
        return aya;
    }

    public String getArabic_text() {
        return arabic_text;
    }

    public String getTranslation() {
        return translation;
    }

    public String getFootnotes() {
        return footnotes;
    }
}
