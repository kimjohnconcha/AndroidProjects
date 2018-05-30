package com.example.werepair.Views.AppFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.werepair.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment implements View.OnClickListener {


    public ProfileFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_profile, container, false);

        View v = inflater.inflate(R.layout.fragment_profile, container, false);


        TextView b = (TextView) v.findViewById(R.id.addrepair);
        b.setOnClickListener(this);

        return v;
    }

    public void AddRepairItems(View view) {
        Log.d("add repair", "here");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addrepair:
                Log.d("add repair", "here");
                break;
        }
    }
}
