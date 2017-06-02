package com.shadoapps.famvisao;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class NavegationActivity extends AppCompatActivity {

    //easy to create this as a final variable cause I always use the same 'manager'
    final FragmentManager fragmentManager = getSupportFragmentManager();

    final Fragment f_left = new LeftFragment();
    final Fragment f_center = new CenterFragment();
    final Fragment f_right = new RightFragment();

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_calendar: //opcao da esq
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.frag_container, f_left).commit();
                    return true;
                case R.id.navigation_main: //opcao do meio
                    FragmentTransaction fragmentTransaction1 = fragmentManager.beginTransaction();
                    fragmentTransaction1.replace(R.id.frag_container, f_center).commit();
                    return true;
                case R.id.navigation_tasks: //opcao da dir
                    FragmentTransaction fragmentTransaction2 = fragmentManager.beginTransaction();
                    fragmentTransaction2.replace(R.id.frag_container,f_right).commit();
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navegation);

        TextView tvteste = (TextView) findViewById(R.id.tvteste);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frag_container, f_left).commit();

        //to initializater the toolbar
        Toolbar toolbarMain = (Toolbar) findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbarMain);

        //to get the support to edit the toolbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

    }

}
