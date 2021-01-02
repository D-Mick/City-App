package com.rotimijohnson.cityapp.userBoard.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.chaos.view.PinView;
import com.rotimijohnson.cityapp.R;

public class SecondVerifyOTP extends AppCompatActivity {
    PinView pinFromUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retailer_second_verify_o_t_p);

        pinFromUser = findViewById(R.id.pin_view);

        String _phoneNo = getIntent().getStringExtra("phoneNo");

        sendVerificationCodeToUser(_phoneNo);
    }

    private void sendVerificationCodeToUser(String phoneNo) {

    }
}
