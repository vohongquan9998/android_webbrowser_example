package com.example.webbrowser;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.net.URL;

public class URLsearchActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnHomeUrl,btnFindUrl;
    private EditText edt_findurl;
    private WebView SearchWebAddress;
    private Toolbar mToolbar;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private NavigationView nav_view;
    private ImageButton img_back,img_forward,img_roll,img_tab;
    String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u_r_lsearch);
        addControl();
        addEvent();
    }

    private void addEvent() {
        WebSettings webSettings = SearchWebAddress.getSettings();
        webSettings.setJavaScriptEnabled(true);
        edt_findurl.setText(url);
        SearchWebAddress.loadUrl(url);
        SearchWebAddress.setWebViewClient(new WebViewClient());

        btnHomeUrl.setOnClickListener(this);
        btnFindUrl.setOnClickListener(this);
        img_back.setOnClickListener(this);
        img_roll.setOnClickListener(this);
        img_forward.setOnClickListener(this);
//        img_tab.setOnClickListener(this);



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
        if(SearchWebAddress.canGoBack())
        {
            SearchWebAddress.goBack();
        }else{
            super.onBackPressed();
        }

    }

    private void addControl() {
        btnFindUrl = this.<Button>findViewById(R.id.btnFindurl);
        btnHomeUrl = this.<Button>findViewById(R.id.btnhomeurl);
        edt_findurl = this.<EditText>findViewById(R.id.edt_findurl);
        SearchWebAddress = this.<WebView>findViewById(R.id.searchAddress);
        url =getIntent().getExtras().get("url_address").toString();
        img_back = this.<ImageButton>findViewById(R.id.btnback);
        img_roll = this.<ImageButton>findViewById(R.id.btnroll);
        img_forward = this.<ImageButton>findViewById(R.id.btnforward);
//        img_tab= this.<ImageButton>findViewById(R.id.btntab);

        nav_view = this.<NavigationView>findViewById(R.id.navigation_view_url);

        mToolbar = this.<Toolbar>findViewById(R.id.main_page_toolbar_url);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("");
        drawerLayout = this.<DrawerLayout>findViewById(R.id.drawable_layout_url);
        drawerToggle = new ActionBarDrawerToggle(URLsearchActivity.this,drawerLayout,R.string.drawer_open,R.string.drawer_close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        View navView = nav_view.inflateHeaderView(R.layout.navigation_header);
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(drawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if(v == btnHomeUrl)
        {
            sendToHomePage();
        }
        if(v == btnFindUrl)
        {
            SearchWebAddress();

        }
        if(v==img_back)
        {
            if(SearchWebAddress.canGoBack())
            {
                SearchWebAddress.goBack();
            }
            else{
                sendToHomePage();
            }
        }
        if(v==img_roll){
            SearchWebAddress.reload();
        }
        if(v==img_forward)
        {
            if(SearchWebAddress.canGoForward())
            {
                SearchWebAddress.goForward();
            }
        }
//        if(v==img_tab){
//            Intent tabIntent = new Intent(getApplicationContext(),MainActivity.class);
//            startActivity(tabIntent);
//        }
    }

    private void sendToHomePage() {
        finish();
        Intent homeIntent = new Intent(URLsearchActivity.this,MainActivity.class);
        startActivity(homeIntent);
    }

    private void SearchWebAddress() {
        String url_ = edt_findurl.getText().toString();
        if(TextUtils.isEmpty(url_)){
            Toast.makeText(URLsearchActivity.this, "Vui lòng hãy nhập địa chỉ", Toast.LENGTH_SHORT).show();
        }
        else
        {
            String url_without_https= url_.replaceAll("https://www.","");
            String https = "https://";
            String www = "www.";
            String com = ".com";
            String vn = "";

            if(url_.endsWith(".com"))
            {
                com = "";
            }
            else
                com = ".com";

            Intent search = new Intent(URLsearchActivity.this,URLsearchActivity.class);
            search.putExtra("url_address",https+www+url_without_https+com);
            startActivity(search);
            edt_findurl.setText("");
            edt_findurl.requestFocus();
        }
    }
}