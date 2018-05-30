package com.example.werepair.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.werepair.R;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class UserLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
    }

    public void NewLogin(View view)
    {
        String URL = "http://192.168.1.5:3000/auth/login";
        Map<String, String> params = new HashMap();
        params.put("email", "testuser1@gmail.com");
        params.put("password", "12345678");

        JSONObject parameters = new JSONObject(params);
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.POST,
                URL,
                parameters,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.e("Response: ", response.toString());

                        try{
                            JSONObject user = response.getJSONObject("user");
                            String name = user.getString("name");
                            // TODO: validation caching for global access
                            Log.e("Response user: ", name);
                        } catch (Exception ex) {
                            Log.e("Error ", ex.getMessage());
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Response error: ", error.toString());
                    }
                }
        );

        //requestQueue.add(jsonObjectRequest);

        Intent intent = new Intent(this, MainNavigation.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        UserLoginActivity.this.finish();
    }

    public void GotoSignup(View view) {
        Intent signup = new Intent(this, SignupActivity.class);
        startActivity(signup);
    }
}
