package com.example.werepair;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class RepairFragment extends Fragment {


    public RepairFragment() {
        // Required empty public constructor
    }

    ListView listView;
    int[] images = {R.drawable.rep1, R.drawable.rep2, R.drawable.rep3};
    String[] Names = {"Repair 1", "Repair 2", "Repair 3"};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_repair, container, false);

        String[] list = {"item 1", "item 2", "item 3"};

        listView = (ListView) view.findViewById(R.id.repairList);

        ArrayAdapter<String> listviewAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                list
        );


        System.out.println("to go to custom");

        CustomAdapter customAdapter = new CustomAdapter();

        listView.setAdapter(customAdapter);

        System.out.println("after custom " + customAdapter.getCount());

        return view;
    }

    class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view1 = getLayoutInflater().inflate(R.layout.repairitemlayout, null);

            ImageView mImageView = (ImageView) view1.findViewById(R.id.imageView);
            TextView mTextView = (TextView) view1.findViewById(R.id.textview);

            mImageView.setImageResource(images[position]);
            mTextView.setText(Names[position]);

            System.out.println("here " + images[1]);

            return view1;
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        listView = (ListView) getActivity().findViewById(R.id.repairList);

        final CustomAdapter customAdapter = new CustomAdapter();

        listView.setAdapter(customAdapter);

        listView.post(new Runnable() {
            public void run() {
                listView.setAdapter(customAdapter);
            }
        });
    }

}
