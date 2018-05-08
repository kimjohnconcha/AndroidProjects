package com.example.workingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.ToggleButton;

public class RegistrationActivity extends AppCompatActivity {

    private boolean isScholar = false;
    private boolean hasInternetConnection = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        // internet connection toggle
        ToggleButton toggle = (ToggleButton) findViewById(R.id.tb1);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    hasInternetConnection = true;
                } else {
                    hasInternetConnection = false;
                }
            }
        });
    }

    public void registerData (View view)
    {

        Intent intent = new Intent(this, DisplayRegMessage.class);

        // Get lastname
        EditText editText_lastname = (EditText) findViewById(R.id.lastname);
        String lastname = editText_lastname.getText().toString();

        // Get firstname
        EditText editText_firstname = (EditText) findViewById(R.id.firstname);
        String firstname = editText_firstname.getText().toString();

        // Get course
        Spinner mySpinner=(Spinner) findViewById(R.id.course_spinner);
        String course = mySpinner.getSelectedItem().toString();

        // Get year
        EditText editText_year = (EditText) findViewById(R.id.year);
        String year = editText_year.getText().toString();

        // Get gender
        RadioGroup radiogroup =  (RadioGroup) findViewById(R.id.radioGender);
        int selectedId = radiogroup.getCheckedRadioButtonId();
        RadioButton radioButton = (RadioButton) findViewById(selectedId);
        CharSequence genSelected = radioButton.getText();


        //add to intent
        intent.putExtra("LAST_NAME", lastname);
        intent.putExtra("FIRST_NAME", firstname);
        intent.putExtra("COURSE", course);
        intent.putExtra("YEAR", year);
        intent.putExtra("GENDER", genSelected);
        intent.putExtra("ISSCHOLAR", isScholar);
        intent.putExtra("HASINTERNETCONN", hasInternetConnection);


        startActivity(intent);
    }

    public void ScholarOptionChecked (View view)
    {
        CheckBox checkBox = (CheckBox)view;
        if(checkBox.isChecked()){
           isScholar = true;
        } else {
            isScholar = false;
        }
    }









}
