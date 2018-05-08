package com.example.workingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayRegMessage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_reg_message);

        String lastname = "";
        String firstname = "";
        String course = "";
        String year = "";
        String gender = "";
        boolean isScholar = false;
        boolean hasInternetCon = false;

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            lastname = extras.getString("LAST_NAME");
            firstname = extras.getString("FIRST_NAME");
            course = extras.getString("COURSE");
            year = extras.getString("YEAR");
            gender = extras.getString("GENDER");
            isScholar = extras.getBoolean("ISSCHOLAR");
            hasInternetCon = extras.getBoolean("HASINTERNETCONN");
        }

        TextView textView = findViewById(R.id.textView);
        String x = "Welcome, \n" +
                "\n Last name: " + lastname +
                "\n First name: " + firstname +
                "\n Course: " + course +
                "\n Year: " + year +
                "\n Gender: " + gender +
                "\n Scholar: " + isScholar +
                "\n Internet Connection: " + hasInternetCon;

        textView.setText(x);
    }
}
