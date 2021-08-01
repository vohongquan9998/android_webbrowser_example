package com.example.webbrowser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.widget.Toolbar;

public class ThemeActivity_Setting extends AppCompatActivity implements View.OnClickListener {

    private Toolbar mToolbar;
    ImageButton hot,normal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme__setting);
        addControl();
        addEvent();
    }

    private void addEvent() {
        //getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        hot.setOnClickListener(this);
        normal.setOnClickListener(this);
    }

    @Override
    public boolean onSupportNavigateUp() {
        Intent settingIntent = new Intent(ThemeActivity_Setting.this,SettingActivity.class);
        startActivity(settingIntent);
        finish();
        return super.onSupportNavigateUp();
    }

    private void addControl() {
        mToolbar = this.<Toolbar>findViewById(R.id.theme_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("");

        hot= findViewById(R.id.hot_theme);
        normal = findViewById(R.id.normal_theme);
    }

    @Override
    public void onClick(View v) {
        if(v==normal)
        {
            ThemeUtils.changeTheme(this,ThemeUtils.NORMAL);
        }
        if(v==hot)
        {
            ThemeUtils.changeTheme(this,ThemeUtils.HOT);
        }
    }
}