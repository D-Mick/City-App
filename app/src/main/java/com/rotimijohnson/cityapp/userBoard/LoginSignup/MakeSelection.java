package com.rotimijohnson.cityapp.userBoard.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.rotimijohnson.cityapp.R;

public class MakeSelection extends AppCompatActivity {
    TextView forgetPasswordText, ForgetPasswordTextSub;
    Animation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retailer_make_selection);

        forgetPasswordText = findViewById(R.id.forget_password_text);
        ForgetPasswordTextSub = findViewById(R.id.forget_password_sub_text);

        animation = AnimationUtils.loadAnimation(this, R.anim.top_animation);

        forgetPasswordText.setAnimation(animation);
        ForgetPasswordTextSub.setAnimation(animation);
    }

    public void otpPage(View view){
        Intent intent = new Intent(MakeSelection.this, VerifyOTP.class);
        startActivity(intent);
    }
}
