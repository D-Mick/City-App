package com.rotimijohnson.cityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.rotimijohnson.cityapp.userBoard.UserBoardActivity;
import com.rotimijohnson.cityapp.walkthrough.WalkthroughActivity;

public class SplashActivity extends AppCompatActivity {
    TextView app_name, app_sub_name;
    ImageView app_img;
    Animation top_anim, bottom_anim;
    private static final int TIMER = 5000;
    SharedPreferences walkthrough;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        app_name = findViewById(R.id.app_name);
        app_sub_name = findViewById(R.id.app_sub_name);
        app_img = findViewById(R.id.app_img);

        top_anim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottom_anim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        app_img.setAnimation(top_anim);
        app_name.setAnimation(bottom_anim);
        app_sub_name.setAnimation(bottom_anim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
               walkthrough = getSharedPreferences("walkthrough", MODE_PRIVATE);
               boolean isFirstTime = walkthrough.getBoolean("firstTime", true);

               if (isFirstTime){
                   SharedPreferences.Editor editor = walkthrough.edit();
                   editor.putBoolean("firstTime", false);
                   editor.commit();
                   Intent intent = new Intent(SplashActivity.this, WalkthroughActivity.class);
                   startActivity(intent);
                   finish();
               }else {
                   Intent intent = new Intent(SplashActivity.this, UserBoardActivity.class);
                   startActivity(intent);
                   finish();
               }
            }
        }, TIMER);
    }
}
