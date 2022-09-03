package com.example.quranmajeed;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.viewHolder>{

    ArrayList<SurahData> surahData;
    Context context;
    LanguageController languageController = new LanguageController() ;
    onItemListener itemListener;

    RecyclerViewAdapter(Context context, ArrayList<SurahData> surahData, onItemListener itemListener)
    {
        this.context = context;
        this.surahData = surahData;
        this.itemListener = itemListener;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list, parent, false);
        viewHolder vh = new viewHolder(view, itemListener);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        if(languageController.getSurahLanguage()) {
            holder.txtEng.setText(surahData.get(position).surahNameEnglish);
            holder.txtId2.setText(surahData.get(position).id);
            holder.txtId.setVisibility(View.INVISIBLE);
            holder.txtUrdu.setVisibility(View.INVISIBLE);
        }
        else
        {
            holder.txtUrdu.setText(surahData.get(position).surahNameUrdu);
            holder.txtId.setText(surahData.get(position).id);
            holder.txtId2.setVisibility(View.INVISIBLE);
            holder.txtEng.setVisibility(View.INVISIBLE);
        }

        holder.txtId.setText(surahData.get(position).id);

    }

    @Override
    public int getItemCount() {
        return surahData.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView txtUrdu;
        TextView txtEng;
        TextView txtId2;
        TextView txtId;
        onItemListener itemListener;

        public viewHolder(@NonNull View itemview, onItemListener itemListener)
        {
            super(itemview);

            txtUrdu = itemview.findViewById(R.id.urdu_txt) ;
            txtId = itemview.findViewById(R.id.id_txt) ;
            txtEng = itemview.findViewById(R.id.eng_txt);
            txtId2 = itemview.findViewById(R.id.id_txt2);
            this.itemListener = itemListener;
            itemview.setOnClickListener(this);

        }


        @Override
        public void onClick(View view) {
            itemListener.onItemClick(getAdapterPosition());
        }
    }

    public interface onItemListener{
        void onItemClick(int position);

    }
}
