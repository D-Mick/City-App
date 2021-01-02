package com.rotimijohnson.cityapp.userBoard.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.rotimijohnson.cityapp.R;

public class Login extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retailer_login);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    public void ForgetPassword(View view) {
        Intent intent  = new Intent(Login.this, ForgetPassword.class);

        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View, String >(findViewById(R.id.forget_passwordBtn), "transition_forget_password");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this, pairs);
            startActivity(intent, options.toBundle());
        }else {
            startActivity(intent);
        }
    }

    public void createAccount(View view){
        Intent intent = new Intent(Login.this, Signup.class);
        startActivity(intent);
    }
}
