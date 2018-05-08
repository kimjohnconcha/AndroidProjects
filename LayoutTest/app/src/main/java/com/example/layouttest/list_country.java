package com.example.layouttest;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class list_country extends ListActivity {
    static  final  String[] COUNTRIES = new String[]{"USA", "CHINA", "KOREA", "JAPAN",
    "UNITED KINGDOM", "CONCHA"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_list_country);

        setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_list_country, COUNTRIES));

        ListView listView = getListView();
        listView.setTextFilterEnabled(true);

        //listView.addHeaderView("sd");


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), ((TextView)view).getText(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}
