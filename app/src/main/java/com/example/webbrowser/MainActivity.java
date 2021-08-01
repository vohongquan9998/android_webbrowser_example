package com.example.webbrowser;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnSearch;
    //private SubmitButton btnSubmit_search;
    private EditText edt_search;
    private ImageView iFace,iYou,iIns,iTwitter,iSnapchat,iGG,iBaomoi,i24h;
    private Toolbar mToolbar;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle,drawerToggleSetting;
    private NavigationView nav_view;
    private ImageButton img_back,img_forward,img_roll,img_tab;
    private WebView news_web;
    private TextView txt_count_tab;
    String newsurl;
    private static int _countTab=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControl();
        addEvent();
    }

    private void addEvent() {
        btnSearch.setOnClickListener(this);
        //btnSubmit_search.setOnClickListener(this);

        iGG.setOnClickListener(this);
        iFace.setOnClickListener(this);
        iTwitter.setOnClickListener(this);
        iYou.setOnClickListener(this);
        iSnapchat.setOnClickListener(this);
        iIns.setOnClickListener(this);
        iBaomoi.setOnClickListener(this);
        i24h.setOnClickListener(this);

        img_back.setOnClickListener(this);
        img_forward.setOnClickListener(this);
        img_roll.setOnClickListener(this);
//        img_tab.setOnClickListener(this);

        WebSettings webSettings = news_web.getSettings();
        webSettings.setJavaScriptEnabled(true);
        news_web.loadUrl("https://www.baomoi.com");
        news_web.setWebViewClient(new WebViewClient());

//        txt_count_tab.setText((_countTab+1)+"");


        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                UserItemSeletor(item);
                return false;
            }
        });
    }

    private void UserItemSeletor(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.nav_exit:
                finish();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        _countTab--;
        txt_count_tab.setText(_countTab+"");
        super.onBackPressed();
    }

    private void addControl() {
        nav_view = this.<NavigationView>findViewById(R.id.navigation_view);
        //nav_view_setting = this.<NavigationView>findViewById(R.id.navigation_view_setting);
        btnSearch = this.<Button>findViewById(R.id.btnFind);
        //btnSubmit_search = findViewById(R.id.btnFind);
        edt_search = this.<EditText>findViewById(R.id.edt_find);
        iFace = this.<ImageView>findViewById(R.id.img_fb);
        iGG = this.<ImageView>findViewById(R.id.img_gg);
        iIns = this.<ImageView>findViewById(R.id.img_insta);
        iYou = this.<ImageView>findViewById(R.id.img_youtube);
        iSnapchat = this.<ImageView>findViewById(R.id.img_snapchat);
        iTwitter = this.<ImageView>findViewById(R.id.img_twitter);
        i24h = this.<ImageView>findViewById(R.id.img_24h);
        iBaomoi = this.<ImageView>findViewById(R.id.img_baomoi);


        img_back = this.<ImageButton>findViewById(R.id.btnback);
        img_forward = this.<ImageButton>findViewById(R.id.btnforward);
        img_roll = this.<ImageButton>findViewById(R.id.btnroll);
//        img_tab = this.<ImageButton>findViewById(R.id.btntab);
//
//        txt_count_tab = this.<TextView>findViewById(R.id.tab_count);

        news_web = this.<WebView>findViewById(R.id.main_news_web);

        mToolbar = this.<Toolbar>findViewById(R.id.main_page_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("");
        drawerLayout = this.<DrawerLayout>findViewById(R.id.drawable_layout);
        drawerToggle = new ActionBarDrawerToggle(MainActivity.this,drawerLayout,R.string.drawer_open,R.string.drawer_close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        View navView = nav_view.inflateHeaderView(R.layout.navigation_header);


    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(drawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if(v == btnSearch)
        {
            OpenWebSite();

        }
        if(v==iFace)
        {
            Intent fbIntent = new Intent(MainActivity.this,URLsearchActivity.class);
            fbIntent.putExtra("url_address","https://www.facebook.com");
            startActivity(fbIntent);
        }
        if(v==iYou)
        {
            Intent youIntent = new Intent(MainActivity.this,URLsearchActivity.class);
            youIntent.putExtra("url_address","https://www.youtube.com");
            startActivity(youIntent);
        }
        if(v==iTwitter)
        {
            Intent twIntent = new Intent(MainActivity.this,URLsearchActivity.class);
            twIntent.putExtra("url_address","https://www.gmail.com");
            startActivity(twIntent);
        }
        if(v==iGG)
        {
            Intent ggIntent = new Intent(MainActivity.this,URLsearchActivity.class);
            ggIntent.putExtra("url_address","https://www.google.com");
            startActivity(ggIntent);
        }
        if(v==iSnapchat)
        {
            Intent scIntent = new Intent(MainActivity.this,URLsearchActivity.class);
            scIntent.putExtra("url_address","https://www.snapchat.com");
            startActivity(scIntent);
        }
        if(v==iIns)
        {
            Intent insIntent = new Intent(MainActivity.this,URLsearchActivity.class);
            insIntent.putExtra("url_address","https://www.instagram.com");
            startActivity(insIntent);
        }
        if(v==iBaomoi)
        {
            news_web.loadUrl("https://www.baomoi.com");
        }
        if(v==i24h)
        {
            news_web.loadUrl("https://www.24h.com.vn");
        }
        if(v==img_back)
        {
            if(news_web.canGoBack())
            {
                news_web.goBack();
            }
        }
        if(v==img_forward)
        {
            if(news_web.canGoForward())
            {
                news_web.goForward();
            }
        }
        if(v==img_roll){
            news_web.reload();
        }
//        if(v==img_tab)
//        {
//            _countTab++;
//            txt_count_tab.setText(_countTab+"");
//            Intent tabIntent = new Intent(getApplicationContext(),MainActivity.class);
//            startActivity(tabIntent);
//        }
    }

    private void OpenWebSite() {
        String url_ = edt_search.getText().toString();
        if(TextUtils.isEmpty(url_)){
            Toast.makeText(this, "Vui lòng hãy nhập địa chỉ", Toast.LENGTH_SHORT).show();
        }
        else
        {
            String url_without_https= url_.replaceAll("https://www.","");
            String https = "https://";
            String www = "www.";
            String com = ".com";

            if(url_.endsWith(".com"))
            {
                com = "";
            }
            else{
                com = ".com";
            }
            Intent search = new Intent(MainActivity.this,URLsearchActivity.class);
            search.putExtra("url_address",https+www+url_without_https+com);
            startActivity(search);

            edt_search.setText("");
            edt_search.requestFocus();
        }
    }
}