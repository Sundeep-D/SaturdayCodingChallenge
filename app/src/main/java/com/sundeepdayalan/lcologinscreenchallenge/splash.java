package com.sundeepdayalan.lcologinscreenchallenge;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class splash extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 1000;
    TextView LCO_Head;
    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        LCO_Head=findViewById(R.id.learncodeonlinetv);
        logo=findViewById(R.id.lco_logo);
        Typeface custom_font1 = Typeface.createFromAsset(getAssets(),  "fonts/arial.ttf");
        LCO_Head.setTypeface(custom_font1);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent login_screen_intent=new Intent(splash.this,Login.class);

                 startActivity(login_screen_intent);

                // nextScreen();

                finish();
            }
        },SPLASH_TIME_OUT);
    }

    private void nextScreen() {

        Intent MainscreenIntent=new Intent(getApplicationContext(),Login.class);
        Pair[] pairs=new Pair[1];
       // pairs[0]=new Pair<View, String>(logo,"logo_transition");
        pairs[0]=new Pair<View, String>(logo,"head_transition");
        ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(splash.this,pairs);
        startActivity(MainscreenIntent,options.toBundle());
    }
}
