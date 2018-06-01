package com.example.werepair.Views.AppFragments;


import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.werepair.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddRepairItemFragment extends Fragment implements View.OnClickListener {

    private final int IMG_REQUEST = 1;
    private String imagePath;
    private static int LOAD_IMAGE_RESULTS = 1;

    private ImageView repair_image;

    public AddRepairItemFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_add_repair_item, container, false);

        repair_image = (ImageView) v.findViewById(R.id.repairImage);

        Button b = (Button) v.findViewById(R.id.choosebtn);
        b.setOnClickListener(this);

        return  v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.choosebtn:
                SelectImagefromGallery();
            break;


        }
    }


    private void SelectImagefromGallery() {
        Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(i,LOAD_IMAGE_RESULTS);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == LOAD_IMAGE_RESULTS && resultCode == getActivity().RESULT_OK && data != null) {

            Uri pickedImage = data.getData();
            String[] filePath = { MediaStore.Images.Media.DATA };
            Cursor cursor = getActivity().getContentResolver().query(pickedImage, filePath, null, null, null);
            cursor.moveToFirst();
            imagePath = cursor.getString(cursor.getColumnIndex(filePath[0]));

            repair_image.setImageBitmap(BitmapFactory.decodeFile(imagePath));

            //Log.d("Image path>>>>>>> ", BitmapFactory.decodeFile(imagePath));
            cursor.close();
        }
    }


}
