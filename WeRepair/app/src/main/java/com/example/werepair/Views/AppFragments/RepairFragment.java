package com.example.werepair.Views.AppFragments;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.werepair.R;
import com.example.werepair.Models.RepairRowItem;
import com.example.werepair.Services.RepairListitemAdapter;

import java.util.ArrayList;
import java.util.List;


    public class RepairFragment extends Fragment implements AdapterView.OnItemClickListener {

        String[] menutitles;
        TypedArray menuIcons;

        RepairListitemAdapter adapter;
        private List<RepairRowItem> rowItems;


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_repair, null, false);
        }

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(getActivity(), menutitles[position], Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {

            super.onActivityCreated(savedInstanceState);

            menutitles = getResources().getStringArray(R.array.titles);
            menuIcons = getResources().obtainTypedArray(R.array.icons);

            rowItems = new ArrayList<RepairRowItem>();

            for (int i = 0; i < menutitles.length; i++) {
                RepairRowItem items = new RepairRowItem(menutitles[i], menuIcons.getResourceId(i, -1));
                rowItems.add(items);
            }

            ListView listView = (ListView) getActivity().findViewById(R.id.repairList);

            adapter = new RepairListitemAdapter(getActivity(), rowItems);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(this);

        }

    }
