package com.example.werepair.Views.AppFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.werepair.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddRepairItemFragment extends Fragment {


    public AddRepairItemFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_repair_item, container, false);
    }

}
