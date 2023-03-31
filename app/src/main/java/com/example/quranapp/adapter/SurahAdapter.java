package com.example.quranapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quranapp.R;
import com.example.quranapp.listener.SurahListener;
import com.example.quranapp.model.Surah;

import java.util.List;

public class SurahAdapter extends RecyclerView.Adapter<SurahAdapter.ViewHolder> {
    private Context context;
    private List<Surah> list;
    private SurahListener surahListener;
    public SurahAdapter(Context context, List<Surah> list,SurahListener surahListener) {
        this.context = context;
        this.list = list;
        this.surahListener=surahListener;
    }

    @NonNull
    @Override
    public SurahAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.surah_layout, parent, false);
        return new ViewHolder(view,surahListener);
    }

    @Override
    public void onBindViewHolder(@NonNull SurahAdapter.ViewHolder holder, int position) {
        holder.name.setText(list.get(position).getName());
        holder.ayahNumber.setText(String.valueOf(list.get(position).getNumber()));
        holder.surahNameEn.setText(list.get(position).getEnglishName());
        holder.surahNameAr.setText(list.get(position).getEnglishNameTranslation());
        holder.totalAyatNo.setText(String.valueOf(list.get(position).getNumberOfAyahs()) + "Aya :");
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name, ayahNumber, totalAyatNo, surahNameAr, surahNameEn;
        private SurahListener surahListener;
//pass the Surah listener interface
        public ViewHolder(@NonNull View itemView, SurahListener surahListener) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            ayahNumber = itemView.findViewById(R.id.aya_no);
            totalAyatNo = itemView.findViewById(R.id.total_no);
            surahNameAr = itemView.findViewById(R.id.arabic_name);
            surahNameEn = itemView.findViewById(R.id.english_name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    surahListener.onSurahListener(getAdapterPosition());
                }
            });

        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
