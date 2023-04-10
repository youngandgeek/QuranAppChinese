package com.example.quranapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quranapp.R;
import com.example.quranapp.model.SurahDetail;

import java.util.ArrayList;
import java.util.List;

public class SurahDetailAdapter extends RecyclerView.Adapter<SurahDetailAdapter.ViewHolder> {

    private Context context;
    private List<SurahDetail> surahDetailList;


    public SurahDetailAdapter(Context context, List<SurahDetail> surahDetailList) {
        this.context = context;
        this.surahDetailList = surahDetailList;
    }

    @NonNull
    @Override
    public SurahDetailAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.ayat_item_layout, parent, false);
                return new ViewHolder(view);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //initialize and declare views in surah_detail.xml layout file this layout will display the Surah
        private TextView ayahNoTv, surahArabicTv, surahTranslateTv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ayahNoTv = itemView.findViewById(R.id.aya_no);
            surahArabicTv = itemView.findViewById(R.id.arabic_text);
            surahTranslateTv = itemView.findViewById(R.id.translate_text);


        }
    }

    @Override
    public void onBindViewHolder(@NonNull SurahDetailAdapter.ViewHolder holder, int position) {
        holder.ayahNoTv.setText(String.valueOf(surahDetailList.get(position).getAya()));
        holder.surahArabicTv.setText(surahDetailList.get(position).getArabic_text());
        holder.surahTranslateTv.setText(surahDetailList.get(position).getTranslation());

    }


    @Override
    public int getItemCount() {
        return surahDetailList.size();
    }

 //for languages
 public void filter(ArrayList<SurahDetail> details){
surahDetailList=details;
notifyDataSetChanged();
}

}
