package com.example.quranmajeed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.quranmajeed.databinding.ActivityMainBinding;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends DrawerBaseActivity {


    ActivityMainBinding activityMainBinding;
    DBHelper dbHelper;
    ArrayList<SurahData> surahNamesList;

    ListView lst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());


        //Importing DB
        dbHelper = new DBHelper(getApplicationContext());
        if(!dbHelper.isDataBaseExists())
        {
            try
            {
                dbHelper.importDataBaseFromAssets();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }


        //Importing Data For DataBase
        try
        {
            surahNamesList = dbHelper.getSurahNames();
//           Toast.makeText(getApplicationContext(), surahNamesList.get(1).surahNameEnglish +" "+ surahNamesList.get(1).Nazool, Toast.LENGTH_LONG).show();

        } catch (Exception e)
        {
            e.printStackTrace();
        }

        // Setting the List to Adapter
        lst = findViewById(R.id.main_list);
        CustomAdapter adapter = new CustomAdapter(this, R.layout.custom_list, surahNamesList);
        lst.setAdapter(adapter);


//        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, surahNamesList);


//        lst = findViewById(R.id.main_list);
//        QDH surahNames = new QDH();
////        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,  surahNames.urduSurahNames);
//        CustomAdapter adapter = new CustomAdapter(this, R.layout.custom_list,  surahNames.urduSurahNames);
//        lst.setAdapter(adapter);
//
//        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                int index = surahNames.SSP[i];
//                int end = surahNames.SSP[i+1];
//
//                Intent intent = new Intent(MainActivity.this, SurahActivity.class);
//
//                intent.putExtra("index", index);
//                intent.putExtra("end", end);
//                startActivity(intent);
//            }
//        });
    }
}