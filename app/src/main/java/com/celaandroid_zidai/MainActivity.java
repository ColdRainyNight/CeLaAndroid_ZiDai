package com.celaandroid_zidai;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.celaandroid_zidai.activitycela.OneActivity;
import com.celaandroid_zidai.activityfragment.HomePage;
import com.celaandroid_zidai.activityfragment.NotLoggedIn;
import com.celaandroid_zidai.activityfragment.TheHeadlines;
import com.celaandroid_zidai.activityfragment.Videos;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private FragmentManager fm;
    private RadioGroup rg;
    private List<Fragment> list;
    private HomePage hp;
    private Videos vd;
    private TheHeadlines th;
    private NotLoggedIn nli;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    /*  // 设置邮件可以点击切换日夜间模式
       FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
       //设置夜间模式
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            *//*  Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*//*
                SharedPreferences sp = getSharedPreferences("user", MODE_PRIVATE);
                if (sp.getBoolean("isNight", false)) {
                    sp.edit().putBoolean("isNight", false).commit();
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                } else {
                    sp.edit().putBoolean("isNight", true).commit();
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }
                recreate();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        rg = (RadioGroup) findViewById(R.id.radioGroup);
        addFragment();//添加数据
        changeFragment();//改变数据
    }

    private void changeFragment() {
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = (RadioButton) group.findViewById(checkedId);
                int tag = Integer.parseInt(rb.getTag().toString());
                FragmentTransaction transaction2 = fm.beginTransaction();
                for (int i = 0; i < list.size(); i++) {
                    if (tag == i) {
                        transaction2.show(list.get(i));
                    } else {
                        transaction2.hide(list.get(i));
                    }
                }
                transaction2.commit();
            }
        });
    }
    private void addFragment() {
        list = new ArrayList<>();
        fm = getSupportFragmentManager();
        hp = new HomePage();
        vd = new Videos();
        th = new TheHeadlines();
        nli = new NotLoggedIn();
        list.add(hp);
        list.add(vd);
        list.add(th);
        list.add(nli);
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.add(R.id.frameLayout, list.get(0));
        transaction.add(R.id.frameLayout, list.get(1));
        transaction.add(R.id.frameLayout, list.get(2));
        transaction.add(R.id.frameLayout, list.get(3));
        transaction.show(list.get(0)).hide(list.get(1)).hide(list.get(2)).hide(list.get(3));
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Intent it = new Intent(MainActivity.this, OneActivity.class);
            startActivity(it);
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        } else if (id == R.id.shezhi) {

        } else if (id == R.id.yejian) {
            //切换夜间模式
            SharedPreferences sp = getSharedPreferences("user", MODE_PRIVATE);
            if (sp.getBoolean("isNight", false)) {
                sp.edit().putBoolean("isNight", false).commit();
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            } else {
                sp.edit().putBoolean("isNight", true).commit();
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
            recreate();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
