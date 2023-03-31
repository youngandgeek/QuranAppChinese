package com.example.quranapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.quranapp.adapter.SurahAdapter;
import com.example.quranapp.common.Common;
import com.example.quranapp.listener.SurahListener;
import com.example.quranapp.model.Surah;
import com.example.quranapp.response.SurahResponse;
import com.example.quranapp.viewmodel.SurahViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SurahListener {

    private RecyclerView surahRv;
    private SurahAdapter surahAdapter;
    private List<Surah> list;
    private SurahViewModel surahViewModel;
    private SurahResponse surahResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        surahRv = findViewById(R.id.suraRv);
        surahRv.setHasFixedSize(true);
        surahRv.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        //ViewModel class is designed to hold and manage UI-related data in a life-cycle conscious way
        surahViewModel = new ViewModelProvider(this).get(SurahViewModel.class);
        surahViewModel.getSurah().observe(this, surahResponse -> {
            for (int i = 0; i < surahResponse.getList().size(); i++) {
                list.add(new Surah(surahResponse.getList().get(i).getNumber(),
                        String.valueOf(surahResponse.getList().get(i).getName()),
                        String.valueOf(surahResponse.getList().get(i).getEnglishName()),
                        //  String.valueOf(surahResponse.getList().get(i).getEnglishNameTranslation()),
                        surahResponse.getList().get(i).getNumberOfAyahs(),
                        String.valueOf(surahResponse.getList().get(i).getRevelationType())
                ));
            }
            if (list.size() != 0) {
                surahAdapter = new SurahAdapter(this, list, this);
                surahRv.setAdapter(surahAdapter);
                surahAdapter.notifyDataSetChanged();
            }
        });
    }
    //implement the SurahListener interface here and pass the data to SurahDetail Activity
    //pass the key in common class and list data
    @Override
    public void onSurahListener(int position) {
        Intent surahDetailsIntent=new Intent(MainActivity.this,SurahDetails.class);
        surahDetailsIntent.putExtra(Common.SURAH_NO,list.get(position).getNumber());
        surahDetailsIntent.putExtra(Common.SURAH_NAME,list.get(position).getName());
        surahDetailsIntent.putExtra(Common.SURAH_TOTAL_AYA,list.get(position).getNumberOfAyahs());
        surahDetailsIntent.putExtra(Common.SURAH_TYPE,list.get(position).getRevelationType());
        surahDetailsIntent.putExtra(Common.SURAH_TRANSLATION,list.get(position).getEnglishNameTranslation());
        startActivity(surahDetailsIntent);

    }

}