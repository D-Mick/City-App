package com.rotimijohnson.cityapp.userBoard.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.rotimijohnson.cityapp.R;

public class SetNewPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_new_password);
    }

    public void SuccessPage(View view){
        Intent intent = new Intent(SetNewPassword.this, ForgetPasswordSuccessMessage.class);
        startActivity(intent);
    }
}
