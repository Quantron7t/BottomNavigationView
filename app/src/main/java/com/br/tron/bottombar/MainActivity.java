package com.br.tron.bottombar;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.br.tron.bottombar.RadioFragment;
import com.br.tron.bottombar.StreamFragment;
import com.br.tron.bottombar.InfoFragment;

public class MainActivity extends AppCompatActivity implements PushStreamLink{

    BottomNavigationView bottomNavigationView;
    private Fragment fragment;
    private FragmentManager fragmentManager;
    //private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        fragment = new RadioFragment();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.main_container, fragment).commit();

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationBar);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                String tag = "";
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                switch (item.getItemId()) {
                    case R.id.nav_button_one:
                        fragment = new RadioFragment();
                        tag = "radio_fragment";
                        transaction.replace(R.id.main_container, fragment, tag).commit();
                        break;
                    case R.id.nav_button_two:
                        fragment = new StreamFragment();
                        tag = "stream_fragment";
                        transaction.replace(R.id.main_container, fragment, tag).commit();
                        break;
                    case R.id.nav_button_three:
                        fragment = new InfoFragment();
                        tag = "info_fragment";
                        transaction.replace(R.id.main_container, fragment, tag).commit();
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public void sendStreamLink(String link) {
        fragment =new StreamFragment();
        fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.main_container, fragment,"stream_fragment").commit();
        getSupportFragmentManager().executePendingTransactions();
        StreamFragment sf=(StreamFragment) getSupportFragmentManager().findFragmentByTag("stream_fragment");
        sf.getUrl(link);
    }

   /* public void performStreamClick(){
        View view = bottomNavigationView.findViewById(R.id.nav_button_two);
        view.performClick();
    }*/



}
