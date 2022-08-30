package com.example.quranmajeed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.quranmajeed.databinding.ActivitySurahBinding;

import java.util.ArrayList;

public class SurahActivity extends DrawerBaseActivity {

    ActivitySurahBinding surahBinding;

    ListView lst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surah);



        //Adding Drawer to Activity and Allocating title
        surahBinding = ActivitySurahBinding.inflate(getLayoutInflater());
        setContentView(surahBinding.getRoot());

        //Allocating title
        allocateActivityTitle("Surah");

        // GET value of Surah from MainActivity through Intent
        int surahNumber = getIntent().getIntExtra("number", 1);

        //DBHelper creation
        DBHelper dbHelper = new DBHelper(getApplicationContext());

        //Getting data in Arraylist from DB
        ArrayList<SurahData> surah = dbHelper.getSurahAyahs(surahNumber);

        //Populationg data in Custom List
        lst = findViewById(R.id.list_surah);
        CustomSurahAdapter adapter = new CustomSurahAdapter(this, R.layout.custom_ayah_list,  surah );
        lst.setAdapter(adapter);



//        Intent intent = getIntent();
//        int index = intent.getIntExtra("index", 0);
//        int end = intent.getIntExtra("end", 0);
//
//        QuranArabicText surahView = new QuranArabicText();
//        ArrayList<String> data = new ArrayList<String>();
//
//        lst = findViewById(R.id.list_surah);
//
//        for (int i = index; i < end - 1; i++) {
//            data.add(surahView.QuranArabicText[i]);
        }

//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,  data);
//        CustomAdapter adapter = new CustomAdapter(this, R.layout.custom_list,  (data.toArray(new String[0]) ) );
//        lst.setAdapter(adapter);

    }
