package com.shadoapps.famvisao;


import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Layout1Activity extends AppCompatActivity {

    private static int LAUNCHER_TIMEOUT= 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout1);

        final ImageView imV= (ImageView)findViewById(R.id.imv);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run(){
                Intent welcomeIntent = new Intent(Layout1Activity.this, Layout2Activity.class);
                startActivity(welcomeIntent);
                overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
                finish();

            }
        }, LAUNCHER_TIMEOUT);
    }

}
