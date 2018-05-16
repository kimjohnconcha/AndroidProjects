package com.example.workingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ContainerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
    }

    public void register (View view) {
        Intent intent = new Intent(this, RegistrationActivity.class);
        startActivity(intent);
    }

    public void login_act (View view) {
        Intent intent = new Intent(this, LoginActivuty.class);
        startActivity(intent);
    }

    public void start_activity (View view) {
        Intent intent = new Intent(this,  MainActivity.class);
        startActivity(intent);
    }

    public void calculator (View view) {
        Intent intent = new Intent(this,  CalcLinear.class);
        startActivity(intent);
    }

    public void linear (View view) {
        Intent intent = new Intent(this,  lineartest.class);
        startActivity(intent);
    }

    public void dp_sample (View view) {
        Intent intent = new Intent(this,  DatePickerSample.class);
        startActivity(intent);
    }

    public void list_countryv (View view) {
        Intent intent = new Intent(this,  Listcountry.class);
        startActivity(intent);
    }
}
