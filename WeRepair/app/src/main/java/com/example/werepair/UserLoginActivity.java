package com.example.werepair;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class UserLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
    }

    public void NewLogin(View view)
    {
        System.out.println("Message here");
    }
}
