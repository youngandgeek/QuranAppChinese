package com.example.quranapp;

import static java.util.Locale.filter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import android.renderscript.Sampler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quranapp.adapter.SurahAdapter;
import com.example.quranapp.adapter.SurahDetailAdapter;
import com.example.quranapp.common.Common;
import com.example.quranapp.model.SurahDetail;
import com.example.quranapp.viewmodel.SurahDetailViewModel;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.List;

public class SurahDetails extends AppCompatActivity {

    private TextView suraName, suraTranslName, suraType;
    private ImageButton searchBtn, translationBtn;
    EditText searchSwrEt;
    private RadioGroup translationRadioGroup;
    private RadioButton translationRadioBtn;
    private RecyclerView surahDetailRv;
    private List<SurahDetail> list;
    private SurahDetailAdapter surahDetailAdapter;
    private SurahDetailViewModel surahDetailViewModel;
    private String chinese_makin = "chinese_makin";
    private String chinese_suliman = "chinese_suliman";
    private String swahili_barawani = "swahili_barawani";
    private String french_montada = "french_montada";
    private String japanese_saeedsato="japanese_saeedsato";

    private String lan;
    private int surahNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surah_details);

        //call the views initialization method
        init();

        //set views received from MainActivity Intent
        surahNo = getIntent().getIntExtra(Common.SURAH_NO, 0);
        suraName.setText(getIntent().getStringExtra(Common.SURAH_NAME));
        suraTranslName.setText(getIntent().getStringExtra(Common.SURAH_TRANSLATION));
        suraType.setText(getIntent().getStringExtra(Common.SURAH_TYPE) + " " +
                getIntent().getIntExtra(Common.SURAH_TOTAL_AYA, 0) + "" + "Aya");
/**
 *
 */

        //set the Surah RecyclerView
        surahDetailRv.setHasFixedSize(true);
        list = new ArrayList<>();
        surahDetailRv.setLayoutManager(new LinearLayoutManager(this));
        surahTranslation(japanese_saeedsato, surahNo);

        searchSwrEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                filter(editable.toString());

            }
        });

        translationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomSheetDialog bottomSheetDialog=new BottomSheetDialog(SurahDetails.this,
                        R.style.BottomSheetDialogTheme);
                LayoutInflater inflater=LayoutInflater.from(getApplicationContext());
                View translationView=inflater.inflate(R.layout.language_selection_layout,
                        findViewById(R.id.translation_container));
                translationView.findViewById(R.id.save_lan_btn).
                        setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                translationRadioGroup = translationView.findViewById(R.id.translation_rg);
                                int selectedId = translationRadioGroup.getCheckedRadioButtonId();
                                translationRadioBtn = translationView.findViewById(selectedId);
                                if (selectedId == -1) {
                                    Toast.makeText(SurahDetails.this, "no language selected", Toast.LENGTH_SHORT).show();
                                } else {


                                    switch (selectedId) {
                                        case R.id.chinese_lan_rb:
                                            lan = chinese_makin;
                                            break;
                                        case R.id.chinese_2_lan_rb:
                                            lan = chinese_suliman;
                                            break;
                                        case R.id.french_lan_rb:
                                            lan = french_montada;
                                            break;
                                        case R.id.swahili_lan_rb:
                                            lan = swahili_barawani;
                                            break;
                                        case R.id.japanese_lan_rb:
                                            lan = japanese_saeedsato;
                                            break;
                                        default:
                                Toast.makeText(SurahDetails.this, "selected" + lan, Toast.LENGTH_SHORT).show();


                                    }
                                    /** if (translationRadioBtn.getText().toString().toLowerCase().trim().equals("chinese_makin")){
                                     lan=chinese_makin;
                                     }
                                     else if (translationRadioBtn.getText().toString().toLowerCase().trim().equals("chinese_suliman")){
                                     lan=chinese_suliman;
                                     }
                                     else if (translationRadioBtn.getText().toString().toLowerCase().trim().equals("swahili_barawani")){
                                     lan=swahili_barawani;
                                     }
                                     else if(translationRadioBtn.getText().toString().toLowerCase().trim().equals("french_montada")){
                                     lan=french_montada;
                                     }
                                     else if (translationRadioBtn.getText().toString().toLowerCase().trim().equals("japanese_saeedsato")){
                                     lan=japanese_saeedsato;
                                     }
                                     **/
                                    surahTranslation(lan, surahNo);
                                    bottomSheetDialog.dismiss();
                                }
                            }
                        });
                bottomSheetDialog.setContentView(translationView);
                bottomSheetDialog.show();

            }
        });


    }
private void filter(String id){
        ArrayList<SurahDetail> surahDetailArrayList=new ArrayList<>();
        for (SurahDetail detail: list){
            if (String.valueOf(detail.getId()).contains(id)){
                surahDetailArrayList.add(detail);
            }
        }
        surahDetailAdapter.filter(surahDetailArrayList);
}

//views initialization
    private void init() {
        suraName = findViewById(R.id.sura_name);
        suraTranslName = findViewById(R.id.sura_transl_name);
        suraType = findViewById(R.id.sura_type);
        searchBtn = findViewById(R.id.search_swr_btn);
        translationBtn = findViewById(R.id.translate_btn);
        searchSwrEt = findViewById(R.id.search_swr_et);
        surahDetailRv = findViewById(R.id.all_surah_rv);

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

            }
        });
    }
}
