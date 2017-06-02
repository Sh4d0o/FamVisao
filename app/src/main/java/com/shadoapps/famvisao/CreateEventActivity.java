package com.shadoapps.famvisao;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.database.FirebaseDatabase;

public class CreateEventActivity extends AppCompatActivity {

    //iniatilizate edittexs
    EditText event_title = (EditText) findViewById(R.id.event_title);
    EditText event_description = (EditText) findViewById(R.id.event_description);
    EditText start_date = (EditText) findViewById(R.id.start_date);
    EditText end_date = (EditText) findViewById(R.id.end_date);
    EditText responsible = (EditText) findViewById(R.id.responsible);
    Spinner spinner_nature = (Spinner) findViewById(R.id.spinner_nature);
    Spinner spinner_types = (Spinner) findViewById(R.id.spinner_types);

    //iniatilizate buttons and set listeners
    Button btn_submeter = (Button) findViewById(R.id.btn_submeter);
    Button btn_cancelar = (Button) findViewById(R.id.btn_cancelar);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);


        btn_cancelar.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  Intent cancelar= new Intent(CreateEventActivity.this, NavegationActivity.class);
                  CreateEventActivity.this.startActivity(cancelar);
              }
        });

        btn_submeter .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent submeter= new Intent(CreateEventActivity.this, EventDetailsActivity.class);
                save();
                CreateEventActivity.this.startActivity(submeter);
            }
        });

        //to initializater the toolbar
        Toolbar toolbarNewEvent = (Toolbar) findViewById(R.id.toolbar_new_event);
        setSupportActionBar(toolbarNewEvent);

        //to get the support to edit the toolbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        //actionBar.collapseActionView();

        //arrays convert to arrayadapters
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.event_types_array, android.R.layout.simple_spinner_item);  //arrayadapter form event_types_array w/ simple layout
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // how to drop the menu w/ simple dropdown layout

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.event_nature, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //set adapters to spinners
        spinner_types.setAdapter(adapter);
        spinner_nature.setAdapter(adapter2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.drop_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_about:
                Intent intentAbout = new Intent(CreateEventActivity.this, Layout1Activity.class);
                startActivity(intentAbout);
                return true;

            case R.id.action_logout:
                Intent intentNewEvent = new Intent(CreateEventActivity.this, Layout1Activity.class);
                startActivity(intentNewEvent);
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    public void save(){
        Event e = new Event();
        e.setTitle(event_title.getText().toString());
        e.setDescription(event_description.getText().toString());
        e.setDeadline(start_date.getText().toString());
        e.setEndDate(end_date.getText().toString());
        e.setResponsableEntity(responsible.getText().toString());
        e.setNature(spinner_nature.getSelectedItem().toString());
        e.setTipification(spinner_types.getSelectedItem().toString());

        FirebaseDatabase database = FirebaseDatabase.getInstance();

    }
}
