package com.example.quranmajeed;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomSurahAdapter extends ArrayAdapter<SurahData> {

    ArrayList<SurahData> data;

    public CustomSurahAdapter(@NonNull Context context, int resource, ArrayList<SurahData> data) {
        super(context, R.layout.custom_ayah_list, data);
        this.data = data;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.custom_ayah_list, null, true);

        TextView arabicTxt = view.findViewById(R.id.arabic_txt);
        TextView transTxt = view.findViewById(R.id.translation_txt);

        arabicTxt.setText(data.get(position).surahNameEnglish);
        transTxt.setText(data.get(position).surahNameUrdu);

        return view;
    }
}

