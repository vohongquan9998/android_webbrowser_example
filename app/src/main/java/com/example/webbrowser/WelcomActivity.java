package com.example.webbrowser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class    WelcomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcom);

        Thread th = new Thread()
        {
            @Override
            public void run() {
               try {
                    sleep(3000);
               }catch(Exception e){
                    e.printStackTrace();
               }
               finally{
                   Intent homeIntent = new Intent(WelcomActivity.this,MainActivity.class);
                   startActivity(homeIntent);
               }

            }
        };
        th.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}