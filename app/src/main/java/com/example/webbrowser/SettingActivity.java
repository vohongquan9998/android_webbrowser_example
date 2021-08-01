package com.example.webbrowser;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class SettingActivity extends AppCompatActivity {


    private NavigationView nav_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        addControl();
        addEvent();
    }

    private void addEvent() {
        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                UserItemSeletor(item);
                return false;
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent mainIntent = new Intent(SettingActivity.this,MainActivity.class);
        startActivity(mainIntent);
        finish();
        super.onBackPressed();
    }

    private void UserItemSeletor(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.nav_giaodien:
                Intent themeIntent = new Intent(SettingActivity.this,ThemeActivity_Setting.class);
                startActivity(themeIntent);
                break;
            case R.id.nav_Cookie:
                break;
            case R.id.nav_Nightmode:
                break;
            case R.id.nav_Font:
                break;
            case R.id.nav_News:
                break;
            case R.id.nav_gioithieu:
                break;
        }
    }

    private void addControl() {
        nav_view = this.<NavigationView>findViewById(R.id.navigation_view_setting);

   }
}