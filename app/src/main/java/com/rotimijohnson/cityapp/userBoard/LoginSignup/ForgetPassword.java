package com.rotimijohnson.cityapp.userBoard.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.rotimijohnson.cityapp.R;

public class ForgetPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retailer_forget_password);
    }

    public void makeSelection(View view){
        Intent intent = new Intent(ForgetPassword.this, MakeSelection.class);
        startActivity(intent);
    }
}
