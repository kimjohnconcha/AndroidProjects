package com.example.werepair.Views.AppFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.werepair.R;
import com.example.werepair.Views.MainNavigation;


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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addrepair:
                Log.d("add repair", "here");
                Fragment fragment = new AddRepairItemFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.mainframe, fragment);
                //fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
        }
    }

//    private void setFragmentView(Fragment fragment) {
//        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//        fragmentTransaction.replace(R.id.mainframe, fragment);
//        fragmentTransaction.commit();
//    }
}
