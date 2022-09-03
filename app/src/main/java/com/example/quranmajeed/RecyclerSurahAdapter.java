package com.example.quranmajeed;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerSurahAdapter extends RecyclerView.Adapter<RecyclerSurahAdapter.viewHolder>{
    ArrayList<SurahData> data;
    Context context;
    LanguageController languageController = new LanguageController() ;

    RecyclerSurahAdapter(Context context, ArrayList<SurahData> data){
        this.context = context;
        this.data = data;
        }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_ayah_list, parent, false);
        viewHolder vh = new RecyclerSurahAdapter.viewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.arabicTxt.setText(data.get(position).Nazool);
        if(languageController.getTranslationLanguage())
        {
            holder.engTxt.setText(data.get(position).surahNameEnglish);
            holder.urduTxt.setVisibility(View.INVISIBLE);
        }
        else
        {
            holder.urduTxt.setText(data.get(position).surahNameUrdu);
            holder.engTxt.setVisibility(View.INVISIBLE);
        }
    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        TextView arabicTxt, urduTxt, engTxt;

        public viewHolder(@NonNull View itemview)
        {
            super(itemview);
            arabicTxt = itemview.findViewById(R.id.arabic_txt);
            urduTxt = itemview.findViewById(R.id.translation_txt_urdu);
            engTxt = itemview.findViewById(R.id.translation_txt_eng);
        }

    }


}
