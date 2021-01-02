package com.rotimijohnson.cityapp.userBoard.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.rotimijohnson.cityapp.R;

import java.util.Calendar;

public class Signup2Class extends AppCompatActivity {
    ImageView backBtn;
    Button next, login;
    TextView title;
    RadioGroup radioGroup;
    RadioButton selectedGender;
    DatePicker datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retailer_signup2_class);

        backBtn = findViewById(R.id.signup_back_button);
        next = findViewById(R.id.signup_next_btn);
        login = findViewById(R.id.signup_login_btn);
        title = findViewById(R.id.signup_title_text);

        radioGroup = findViewById(R.id.radio_group);
        datePicker = findViewById(R.id.date_picker);
    }

    public void callNextSignupScreen(View view) {
        if (!vallidateGender() | !validateAge()){
            return;
        }

        selectedGender = findViewById(radioGroup.getCheckedRadioButtonId());
        String _gender = selectedGender.getText().toString().trim();

        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year = datePicker.getYear();

        String date = day+"/"+month+"/"+year;

        String _fullname = getIntent().getStringExtra("fullname");
        String _username = getIntent().getStringExtra("username");
        String _email = getIntent().getStringExtra("email");
        String _password = getIntent().getStringExtra("password");


        Intent intent = new Intent(getApplicationContext(), SignUp3Class.class);
        intent.putExtra(_fullname, "fullname");
        intent.putExtra(_username, "username");
        intent.putExtra(_email, "email");
        intent.putExtra(_password, "password");
        intent.putExtra(_gender,"gender");
        intent.putExtra(date,"date");


        Pair[] pairs = new Pair[4];
        pairs[0] = new Pair<View, String>(backBtn, "transition_back_arrow_btn");
        pairs[1] = new Pair<View, String>(next, "transition_next_btn");
        pairs[2] = new Pair<View, String>(login, "transition_login_btn");
        pairs[3] = new Pair<View, String>(title, "transition_title_text");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Signup2Class.this, pairs);
            startActivity(intent, options.toBundle());
        } else {
            startActivity(intent);
        }
    }


    public void loginScreen2(View view){
        Intent intent = new Intent(Signup2Class.this, Login.class);
        startActivity(intent);
    }

    //Validate Methods

    private boolean vallidateGender(){
        if (radioGroup.getCheckedRadioButtonId() == -1){
            Toast.makeText(this, "Please select a Gender", Toast.LENGTH_SHORT).show();
            return false;
        }else {
            return true;
        }
    }

    private boolean validateAge(){
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int userAge = datePicker.getYear();

        int isAgeValid = currentYear - userAge;

        if (isAgeValid <= 14){
            Toast.makeText(this, "You are not eligible to apply", Toast.LENGTH_SHORT).show();
            return false;
        }else {
            return true;
        }
    }
}
