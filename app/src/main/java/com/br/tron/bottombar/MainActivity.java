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
    View view;
    //private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        fragment = new RadioFragment();
        fragment.setRetainInstance(true);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.main_container, fragment).commit();

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationBar);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                String tag = "";
                switch (item.getItemId()) {
                    case R.id.nav_button_one:
                        fragment = new RadioFragment();
                        fragment.setRetainInstance(true);

                        tag = "radio_fragment";
                        break;
                    case R.id.nav_button_two:
                        fragment = new StreamFragment();
                        fragment.setRetainInstance(true);

                        tag = "stream_fragment";
                        break;
                    case R.id.nav_button_three:
                        fragment = new InfoFragment();
                        fragment.setRetainInstance(true);

                        tag = "info_fragment";
                        break;
                }
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.main_container, fragment, tag).commit();

                return true;
            }
        });
    }

    @Override
    public void sendStreamLink(String link) {
        fragment =new StreamFragment();
        fragment.setRetainInstance(true);
        fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.main_container, fragment,"stream_fragment").addToBackStack(null).commit();
        getSupportFragmentManager().executePendingTransactions();
        StreamFragment sf=(StreamFragment) getSupportFragmentManager().findFragmentByTag("stream_fragment");
        sf.getUrl(link);
        view = bottomNavigationView.findViewById(R.id.nav_button_two);
        view.performClick();
    }

   /* public void performStreamClick(){
        View view = bottomNavigationView.findViewById(R.id.nav_button_two);
        view.performClick();
    }*/



}