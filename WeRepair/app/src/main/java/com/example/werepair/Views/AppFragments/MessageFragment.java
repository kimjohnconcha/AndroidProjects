package com.example.werepair.Views.AppFragments;


import android.app.Activity;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.werepair.Models.MessageItem;
import com.example.werepair.R;
import com.example.werepair.Services.MessageListItemAdapter;
import com.example.werepair.Services.NotificatonListItemAdapter;
import com.example.werepair.Views.Controls.MessageChat;
import com.github.bassaer.chatmessageview.view.ChatView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MessageFragment extends Fragment implements AdapterView.OnItemClickListener {

    String[] messagedates;
    String[] messages;
    TypedArray profileIcons;

    MessageListItemAdapter messageListItemAdapter;
    private List<MessageItem> rowItems;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_message, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        messagedates = getResources().getStringArray(R.array.dates);
        messages = getResources().getStringArray(R.array.messtxt);
        profileIcons = getResources().obtainTypedArray(R.array.proicons);

        rowItems = new ArrayList<MessageItem>();

        for (int i = 0; i < messages.length; i++) {
            MessageItem items = new MessageItem(messagedates[i], messages[i],
                    profileIcons.getResourceId(i, -1));
            rowItems.add(items);
        }

        ListView listView = (ListView) getActivity().findViewById(R.id.messageList);

        messageListItemAdapter = new MessageListItemAdapter(getActivity(), rowItems);
        listView.setAdapter(messageListItemAdapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent chat_i = new Intent(getActivity(), MessageChat.class);
        startActivity(chat_i);
        ((Activity) getActivity()).overridePendingTransition(0,0);
    }
}
