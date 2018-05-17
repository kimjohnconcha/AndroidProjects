package com.example.werepair.Services;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.werepair.Models.MessageItem;
import com.example.werepair.R;

import java.util.List;

public class MessageListItemAdapter extends BaseAdapter {

    Context context;
    List<MessageItem> rowItem;

    public MessageListItemAdapter(Context context, List<MessageItem> rowItem) {
        this.context = context;
        this.rowItem = rowItem;
    }

    @Override
    public int getCount() {
        return rowItem.size();
    }

    @Override
    public Object getItem(int position) {
        return rowItem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return rowItem.indexOf(getItem(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.messageitemlayout, null);
        }

        ImageView profIcon = (ImageView) convertView.findViewById(R.id.imageViewm);
        TextView message_txt = (TextView) convertView.findViewById(R.id.messagetxt);
        TextView mess_date = (TextView) convertView.findViewById(R.id.messagedate);

        MessageItem row_pos = rowItem.get(position);

        // setting the image resource and title
        profIcon.setImageResource(row_pos.getProfile_icon());
        message_txt.setText(row_pos.getMessage());
        mess_date.setText(row_pos.getDatetime());

        return convertView;
    }
}
