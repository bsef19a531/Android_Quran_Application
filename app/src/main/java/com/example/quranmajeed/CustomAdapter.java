package com.example.quranmajeed;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<SurahData> {

    ArrayList<SurahData> data;

    public CustomAdapter(@NonNull Context context, int resource, ArrayList<SurahData> data) {
        super(context, R.layout.custom_list, data);
        this.data = data;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.custom_list, null, true);
//        ((TextView) view.findViewById(R.id.custom_txt)).setText(data.get(position).surahNameEnglish);
        TextView txtUrdu = view.findViewById(R.id.urdu_txt) ;
//        TextView txtEng = view.findViewById(R.id.eng_txt) ;
        TextView txtId = view.findViewById(R.id.id_txt) ;
//        TextView txtNazool = view.findViewById(R.id.nazool_txt) ;
        txtUrdu.setText(data.get(position).surahNameUrdu);
//        txtEng.setText(data.get(position).surahNameEnglish);
        txtId.setText(data.get(position).id);
//        txtNazool.setText(data.get(position).Nazool);
        return view;
    }
}
