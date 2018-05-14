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

import com.example.werepair.Models.NotificationItem;
import com.example.werepair.R;
import com.example.werepair.Services.NotificatonListItemAdapter;

import java.util.ArrayList;
import java.util.List;


public class NotificationFragment extends Fragment implements AdapterView.OnItemClickListener {

        String[] notidates;
        String[] notifications;
        TypedArray profileIcons;

        NotificatonListItemAdapter notificationListItemAdapter;
        private List<NotificationItem> rowItems;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notification, container, false);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getActivity(), notifications[position], Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        notidates = getResources().getStringArray(R.array.dates);
        notifications = getResources().getStringArray(R.array.notitxt);
        profileIcons = getResources().obtainTypedArray(R.array.proicons);

        rowItems = new ArrayList<NotificationItem>();

        for (int i = 0; i < notifications.length; i++) {
            NotificationItem items = new NotificationItem(notidates[i], profileIcons.getResourceId(i, -1), notifications[i]);
            rowItems.add(items);
        }

        ListView listView = (ListView) getActivity().findViewById(R.id.notificationList);

        notificationListItemAdapter = new NotificatonListItemAdapter(getActivity(), rowItems);
        listView.setAdapter(notificationListItemAdapter);
        listView.setOnItemClickListener(this);
    }
}
