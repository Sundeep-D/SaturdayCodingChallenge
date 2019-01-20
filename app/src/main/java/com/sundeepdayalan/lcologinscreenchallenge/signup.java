package com.sundeepdayalan.lcologinscreenchallenge;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.dd.morphingbutton.MorphingButton;

public class signup extends AppCompatActivity {
    ImageView lco_logo,star;
    TextView LCO_Head,startlearningtv;
    EditText usrname,mail;
    MorphingButton accept_and_continue;
    private int mMorphCounter1 = 1;
    private int mMorphCounter2 = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        usrname=findViewById(R.id.name);
        mail=findViewById(R.id.mail);
        accept_and_continue= (MorphingButton) findViewById(R.id.accept_and_continue);

//        LCO_Head=findViewById(R.id.learncodeonlinetv);
        Typeface custom_font1 = Typeface.createFromAsset(getAssets(),  "fonts/arial.ttf");
        usrname.setTypeface(custom_font1);
        mail.setTypeface(custom_font1);
    }

    public void accept_and_continue(View view) {
        onMorphButton1Clicked(accept_and_continue);
    }


    private void onMorphButton1Clicked(final MorphingButton btnMorph) {
        if (mMorphCounter1 == 0) {
            mMorphCounter1++;
            morphToSuccess(btnMorph);
        } else if (mMorphCounter1 == 1) {
            mMorphCounter1 = 0;
            morphToSuccess(btnMorph);
        }
    }

    private void morphToSuccess(final MorphingButton btnMorph) {
        MorphingButton.Params circle = MorphingButton.Params.create()
                .duration(500)
                .cornerRadius(50)
                .width(700)
                .height(150)
                .color(R.color.subcolor)
                .colorPressed(R.color.morph_pressed)
                .text("Success")
                .icon(R.drawable.success);
        btnMorph.morph(circle);


        delay();   //waiting for button animation to finish

    }

    private void delay() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent MainscreenIntent=new Intent(getApplicationContext(),MainScreen.class);

                startActivity(MainscreenIntent);
            }
        }, 1000);
    }
}
