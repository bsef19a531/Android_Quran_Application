package com.example.quranmajeed;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.quranmajeed.databinding.ActivitySettingBinding;

public class SettingActivity extends DrawerBaseActivity {

    ActivitySettingBinding activitySettingBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        activitySettingBinding = ActivitySettingBinding.inflate(getLayoutInflater());
        setContentView(activitySettingBinding.getRoot());

        allocateActivityTitle("Settings");



        RadioGroup rg = findViewById(R.id.surahRdGrp);
        LanguageController languageController = new LanguageController();
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i)
                {
                    case R.id.surahRdBtnUrdu:
                        languageController.setSurahLanguage(false);
                        break;
                    case R.id.surahRdBtnEnglish:
                        languageController.setSurahLanguage(true);
                }
            }
        });

    }


}