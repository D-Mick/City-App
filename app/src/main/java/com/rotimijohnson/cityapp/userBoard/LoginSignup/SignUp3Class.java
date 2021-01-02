package com.rotimijohnson.cityapp.userBoard.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ScrollView;

import com.google.android.material.textfield.TextInputLayout;
import com.hbb20.CountryCodePicker;
import com.rotimijohnson.cityapp.R;

public class SignUp3Class extends AppCompatActivity {
    ScrollView scrollView;
    TextInputLayout phoneNumber;
    CountryCodePicker countryCodePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retailer_sign_up3_class);

        scrollView = findViewById(R.id.sign_up_scroll_view);
        phoneNumber = findViewById(R.id.phone_number);
        countryCodePicker = findViewById(R.id.country_code_picker);
    }


    public void otpVerify(View view){



        String _fullname = getIntent().getStringExtra("fullname");
        String _username = getIntent().getStringExtra("username");
        String _email = getIntent().getStringExtra("email");
        String _password = getIntent().getStringExtra("password");
        String _gender = getIntent().getStringExtra("gender");
        String _date = getIntent().getStringExtra("date");

        String _getUserEnteredPhoneNumber = phoneNumber.getEditText().getText().toString().trim();
        String _phoneNo = "+"+countryCodePicker.getFullNumber()+_getUserEnteredPhoneNumber;


        Intent intent = new Intent(SignUp3Class.this, SecondVerifyOTP.class);
        intent.putExtra(_fullname, "fullname");
        intent.putExtra(_username, "username");
        intent.putExtra(_email, "email");
        intent.putExtra(_password, "password");
        intent.putExtra(_gender,"gender");
        intent.putExtra(_date,"date");
        intent.putExtra(_phoneNo,"phoneNo");

        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View, String>(scrollView, "OtpTransitionName");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(SignUp3Class.this,pairs);
            startActivity(intent, activityOptions.toBundle());
        }
        startActivity(intent);
    }

    public void loginScreen3(View view){
        Intent intent = new Intent(SignUp3Class.this, Login.class);
        startActivity(intent);
    }
}
