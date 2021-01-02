package com.rotimijohnson.cityapp.userBoard.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.rotimijohnson.cityapp.R;

public class VerifyOTP extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retailer_verify_o_t_p);
    }

    public void setNewPassword(View view){
        Intent intent = new Intent(VerifyOTP.this, SetNewPassword.class);
        startActivity(intent);
    }
}
