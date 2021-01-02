package com.rotimijohnson.cityapp.userBoard.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.rotimijohnson.cityapp.R;

public class RetailerStartUpScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retailer_start_up_screen);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    public void callLoginScreen(View view){
        Intent intent = new Intent(getApplicationContext(), Login.class);

        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View,String>(findViewById(R.id.login_btn),"transition_login");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(RetailerStartUpScreen.this, pairs);
            startActivity(intent,options.toBundle());
        }else{
            startActivity(intent);
        }
    }

    public void callSignupScreen(View view){
        Intent intent = new Intent(getApplicationContext(), Signup.class);

        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View,String>(findViewById(R.id.sign_up_btn), "transitions_signup");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(RetailerStartUpScreen.this, pairs);
            startActivity(intent, options.toBundle());
        }else{
            startActivity(intent);
        }
    }
}
