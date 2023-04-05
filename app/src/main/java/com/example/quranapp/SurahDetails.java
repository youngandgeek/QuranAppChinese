package com.example.quranapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import android.renderscript.Sampler;
import android.util.Log;
import android.widget.TextView;

import com.example.quranapp.adapter.SurahAdapter;
import com.example.quranapp.adapter.SurahDetailAdapter;
import com.example.quranapp.common.Common;
import com.example.quranapp.model.SurahDetail;
import com.example.quranapp.viewmodel.SurahDetailViewModel;

import java.util.ArrayList;
import java.util.List;

public class SurahDetails extends AppCompatActivity {

    private TextView suraName, suraTranslName, suraType;
    ///private ImageButton searchBtn,translationBtn;
    // EditText searchSwrEt;
    private RecyclerView surahDetailRv;
    private List<SurahDetail> list;
    private SurahDetailAdapter surahDetailAdapter;
    private SurahDetailViewModel surahDetailViewModel;
    private String chinese_makin = "chinese_makin";
    //private String chinese_suliman="chinese_suliman"
    //private String swahili_barawani="swahili_barawani"
    //private String french_montada="private String "

    private int surahNo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surah_details);
        suraName = findViewById(R.id.sura_name);
        suraTranslName = findViewById(R.id.sura_transl_name);
        suraType = findViewById(R.id.sura_type);

        //  searchBtn=findViewById(R.id.search_swr_btn);
        //translationBtn=findViewById(R.id.translate_btn);
        //searchSwrEt=findViewById(R.id.search_swr_et);

        //initialize views in surahDetails layout
        surahNo = getIntent().getIntExtra(Common.SURAH_NO, 0);
        suraName.setText(getIntent().getStringExtra(Common.SURAH_NAME));
        suraTranslName.setText(getIntent().getStringExtra(Common.SURAH_TRANSLATION));
        suraType.setText(getIntent().getStringExtra(Common.SURAH_TYPE) + " " +
                getIntent().getIntExtra(Common.SURAH_TOTAL_AYA, 0) +""+ "Aya");
/**
 *
 */
        surahDetailRv = findViewById(R.id.all_surah_rv);
        surahDetailRv.setHasFixedSize(true);
        list = new ArrayList<>();
        surahDetailRv.setLayoutManager(new LinearLayoutManager(this));
        surahTranslation(chinese_makin, surahNo);


    }

    private void surahTranslation(String lan, int id) {
        if (list.size() > 0) {
            list.clear();
        }
        surahDetailViewModel = new ViewModelProvider(this).get(SurahDetailViewModel.class);
        surahDetailViewModel.getSurahDetail(lan, id).observe(this, surahDetailResponse -> {

            for (int i = 0; i < surahDetailResponse.getSurahDetailList().size(); i++) {

                list.add(new SurahDetail(surahDetailResponse.getSurahDetailList().get(i).getId(),
                        surahDetailResponse.getSurahDetailList().get(i).getSura(),
                        surahDetailResponse.getSurahDetailList().get(i).getAya(),
                        surahDetailResponse.getSurahDetailList().get(i).getArabic_text(),
                        surahDetailResponse.getSurahDetailList().get(i).getTranslation(),
                        surahDetailResponse.getSurahDetailList().get(i).getFootnotes()));
            }
            if (list.size() != 0) {
                surahDetailAdapter = new SurahDetailAdapter(this, list);
                surahDetailRv.setAdapter(surahDetailAdapter);
                surahDetailAdapter.notifyDataSetChanged();

            }
        });
    }
}
