package com.shadoapps.famvisao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class EventDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        //to initializater the toolbar
        Toolbar toolbarMain = (Toolbar) findViewById(R.id.toolbar_event_details);
        setSupportActionBar(toolbarMain);
    }
}
