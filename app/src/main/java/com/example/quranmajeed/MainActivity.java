package com.example.quranmajeed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.quranmajeed.databinding.ActivityMainBinding;

public class MainActivity extends DrawerBaseActivity {


    ActivityMainBinding activityMainBinding;

    ListView lst;

    Button splash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        lst = findViewById(R.id.main_list);
        QDH surahNames = new QDH();
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,  surahNames.urduSurahNames);
        CustomAdapter adapter = new CustomAdapter(this, R.layout.custom_list,  surahNames.urduSurahNames);
        lst.setAdapter(adapter);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int index = surahNames.SSP[i];
                int end = surahNames.SSP[i+1];

                Intent intent = new Intent(MainActivity.this, SurahActivity.class);

                intent.putExtra("index", index);
                intent.putExtra("end", end);
                startActivity(intent);
            }
        });
    }
}