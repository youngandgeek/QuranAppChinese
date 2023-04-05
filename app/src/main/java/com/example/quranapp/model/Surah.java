package com.example.quranapp.model;

import com.google.gson.annotations.SerializedName;

public class Surah {
//initialize the json data variables received from the API
    @SerializedName("number")
    private int number;
    @SerializedName("name")
    private String name;
    @SerializedName("englishName")
    private String englishName;
    @SerializedName("englishNameTranslation")
    private String englishNameTranslation;
    @SerializedName("numberOfAyahs")
    private int numberOfAyahs;
    @SerializedName("revelationType")
    private String revelationType;

    public void setNumber(int number) {
        this.number = number;
    }

    public Surah(int number, String name, String englishName,String englishNameTranslation, int numberOfAyahs, String revelationType) {
        this.number = number;
        this.name = name;
        this.englishName = englishName;
        this.englishNameTranslation = englishNameTranslation;
        this.numberOfAyahs = numberOfAyahs;
        this.revelationType = revelationType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public void setEnglishNameTranslation(String englishNameTranslation) {
        this.englishNameTranslation = englishNameTranslation;
    }

    public void setNumberOfAyahs(int numberOfAyahs) {
        this.numberOfAyahs = numberOfAyahs;
    }

    public void setRevelationType(String revelationType) {
        this.revelationType = revelationType;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getEnglishName() {
        return englishName;
    }

    public String getEnglishNameTranslation() {
        return englishNameTranslation;
    }

    public int getNumberOfAyahs() {
        return numberOfAyahs;
    }

    public String getRevelationType() {
        return revelationType;
    }




}
