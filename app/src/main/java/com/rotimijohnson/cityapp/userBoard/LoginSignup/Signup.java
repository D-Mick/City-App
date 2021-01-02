package com.rotimijohnson.cityapp.userBoard.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;
import com.rotimijohnson.cityapp.R;

public class Signup extends AppCompatActivity {

    ImageView backBtn;
    Button next, login;
    TextView title;

    TextInputLayout fullname, username, email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retailer_signup);

        //animation variables
        backBtn = findViewById(R.id.signup_back_button);
        next = findViewById(R.id.signup_next_btn);
        login = findViewById(R.id.signup_login_btn);
        title = findViewById(R.id.signup_title_text);

        //validate variables
        fullname = findViewById(R.id.sign_up_full_name);
        username = findViewById(R.id.sign_up_user_name);
        email = findViewById(R.id.sign_up_email);
        password = findViewById(R.id.sign_up_password);
    }

    public void callNextSignupScreen(View view) {

        if (!validateFullName() | !validateUserName() | !validateEmail() | !validatePassword()) {
            return;
        }

        String _fullname = fullname.getEditText().getText().toString().trim();
        String _username = username.getEditText().getText().toString().trim();
        String _email = email.getEditText().getText().toString().trim();
        String _password = password.getEditText().getText().toString().trim();


        Intent intent = new Intent(getApplicationContext(), Signup2Class.class);
        intent.putExtra("fullname", _fullname);
        intent.putExtra("username", _username);
        intent.putExtra("email", _email);
        intent.putExtra("password", _password);


        Pair[] pairs = new Pair[4];
        pairs[0] = new Pair<View, String>(backBtn, "transition_back_arrow_btn");
        pairs[1] = new Pair<View, String>(next, "transition_next_btn");
        pairs[2] = new Pair<View, String>(login, "transition_login_btn");
        pairs[3] = new Pair<View, String>(title, "transition_title_text");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Signup.this, pairs);
            startActivity(intent, options.toBundle());
        } else {
            startActivity(intent);
        }
    }

    public void loginScreen(View view){
        Intent intent = new Intent(Signup.this, Login.class);
        startActivity(intent);
    }

    //Validate methods

    private boolean validateFullName() {
        String valfullname = fullname.getEditText().getText().toString().trim();

        if (valfullname.isEmpty()) {
            fullname.setError("Field can't be empty");
            return false;
        } else {
            fullname.setError(null);
            fullname.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validateUserName() {
        String valfullname = username.getEditText().getText().toString().trim();
        String noWhiteSpace = "\\A\\W{4,20}\\Z";

        if (valfullname.isEmpty()) {
            username.setError("Field can't be empty");
            return false;
        } else if (valfullname.length() >= 25) {
            username.setError("Full name too long");
            return false;
        } else if (valfullname.matches(noWhiteSpace)) {
            username.setError("White spaces not allowed");
            return false;
        } else {
            username.setError(null);
            username.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validateEmail() {
        String val = email.getEditText().getText().toString().trim();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (val.isEmpty()) {
            email.setError("Field cannot be empty");
            return false;
        } else if (!val.matches(emailPattern)) {
            email.setError("Invalid email address");
            return false;
        } else {
            email.setError(null);
            email.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validatePassword() {
        String val = password.getEditText().getText().toString().trim();
        String passwordval = "^(?:(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*)[^\\s]{8,}$";

        if (val.isEmpty()) {
            password.setError("Field cannot be empty");
            return false;
        } else if (!val.matches(passwordval)) {
            password.setError("Password must contain at least 8 letters, one lowercase, one uppercase, one number, one special character");
            return false;
        } else {
            password.setError(null);
            password.setErrorEnabled(false);
            return true;
        }
    }
}
