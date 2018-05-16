package com.example.workingapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class LoginActivuty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activuty);
    }

    public void login (View view)
    {
        EditText editText_username = (EditText) findViewById(R.id.username);
        EditText editText_password = (EditText) findViewById(R.id.password);

        String username = editText_username.getText().toString();
        String password = editText_password.getText().toString();

        System.out.println(username);
        System.out.println(password);

        AlertDialog alertDialog = new AlertDialog.Builder(LoginActivuty.this).create();

        if (!username.equals("makoto") || !password.equals("12345678")) {
            alertDialog.setTitle("Invalid credentials");
            alertDialog.setMessage("Username and/or password is incorrect.");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Close",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        } else {
            alertDialog.setTitle("Login success");
            alertDialog.setMessage("Welcome, Makoto!");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Close",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        }

        alertDialog.show();

    }

    public void reset (View view)
    {
//        EditText editText_username = (EditText) findViewById(R.id.username);
//        EditText editText_password = (EditText) findViewById(R.id.password);
//        editText_username.getText().clear();
//        editText_password.getText().clear();

        finish();
    }


}
