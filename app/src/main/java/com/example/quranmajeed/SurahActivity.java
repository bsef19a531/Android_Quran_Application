package com.example.quranmajeed;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.quranmajeed.databinding.ActivitySurahBinding;

import java.util.ArrayList;
import java.util.Collections;

public class SurahActivity extends DrawerBaseActivity {

    ActivitySurahBinding surahBinding;

    RecyclerView recyclerView;
//    ListView lst;
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
        //Collections.reverse(surah);

        //Populating data in Recycler View
        recyclerView = findViewById(R.id.list_surah);
        recyclerView.setLayoutManager(new LinearLayoutManager(SurahActivity.this, LinearLayoutManager.VERTICAL, false));
        RecyclerSurahAdapter adapter = new RecyclerSurahAdapter(this, surah);
        recyclerView.setAdapter(adapter);

//        //Populationg data in Custom List
//        lst = findViewById(R.id.list_surah);
//        CustomSurahAdapter adapter = new CustomSurahAdapter(this, R.layout.custom_ayah_list,  surah );
//        lst.setAdapter(adapter);


    }}
