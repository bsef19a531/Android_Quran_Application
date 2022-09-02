package com.example.quranmajeed;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

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

    }


}