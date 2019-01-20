package com.sundeepdayalan.lcologinscreenchallenge;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    ImageView lco_logo,star;
    long animationDuration=400;
    TextView LCO_Head,startlearningtv;
    EditText usernameED,passwordED;
    LinearLayout login_LL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        LCO_Head=findViewById(R.id.learncodeonlinetv);
        star=findViewById(R.id.star);
        startlearningtv=findViewById(R.id.startlearningtv);
        usernameED=findViewById(R.id.usernameED);
        passwordED=findViewById(R.id.passwordED);
        login_LL=findViewById(R.id.login_LL);
        Typeface custom_font1 = Typeface.createFromAsset(getAssets(),  "fonts/arial.ttf");
        LCO_Head.setTypeface(custom_font1);
        usernameED.setTypeface(custom_font1);
        passwordED.setTypeface(custom_font1);
        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/Century Gothic.ttf");
        startlearningtv.setTypeface(custom_font);

       final  ObjectAnimator animatorx=ObjectAnimator.ofFloat(login_LL,"x",30f);
       //final ObjectAnimator animatory=ObjectAnimator.ofFloat(login_LL,"y",20f);
        animatorx.setDuration(1000);
      // animatory.setDuration(animationDuration);
        ObjectAnimator rotation=ObjectAnimator.ofFloat(star,"rotation",-10f,0f);
        rotation.setDuration(500);
       final  AnimatorSet animatorSet=new AnimatorSet();
        animatorSet.playTogether(animatorx,rotation);
        animatorSet.start();


//      animatorx.addListener(new AnimatorListenerAdapter() {
//          @Override
//          public void onAnimationEnd(Animator animation) {
//              super.onAnimationEnd(animation);
//
//              ObjectAnimator rotation=ObjectAnimator.ofFloat(star,"rotation",320f,0f);
//              rotation.setDuration(500);
//              AnimatorSet animatorSet=new AnimatorSet();
//              animatorSet.playTogether(rotation);
//              animatorSet.start();
//
//          }
//
//          @Override
//          public void onAnimationStart(Animator animation) {
//              super.onAnimationStart(animation);
//
//          }
//      });
    }

    public void signup(View view) {
        Intent login_screen_intent=new Intent(Login.this,signup.class);

        startActivity(login_screen_intent);
    }
}
