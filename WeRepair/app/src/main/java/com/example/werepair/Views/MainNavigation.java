package com.example.werepair.Views;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.werepair.Views.AppFragments.MessageFragment;
import com.example.werepair.Views.AppFragments.NearbyFragment;
import com.example.werepair.Views.AppFragments.NotificationFragment;
import com.example.werepair.Views.AppFragments.ProfileFragment;
import com.example.werepair.Views.AppFragments.RepairFragment;
import com.example.werepair.R;
import com.example.werepair.Services.BottomNavigationViewHelper;

public class MainNavigation extends AppCompatActivity {

    private RepairFragment repairFragment;
    private NotificationFragment notificationFragment;
    private NearbyFragment nearbyFragment;
    private MessageFragment messageFragment;
    private ProfileFragment profileFragment;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_dashboard:
                    setFragmentView(repairFragment);
                    return true;
                case R.id.navigation_notifications:
                    setFragmentView(notificationFragment);
                    return true;
                case R.id.navigation_nearme:
                    setFragmentView(nearbyFragment);
                    return true;
                case R.id.navigation_messages:
                    setFragmentView(messageFragment);
                    return true;
                case R.id.navigation_profile:
                    setFragmentView(profileFragment);
                    return true;
            }
            return false;
        }
    };

    private void setFragmentView(Fragment fragment) {
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.mainframe, fragment);
        fragmentTransaction.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_navigation);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);

        repairFragment = new RepairFragment();
        notificationFragment = new NotificationFragment();
        nearbyFragment = new NearbyFragment();
        messageFragment = new MessageFragment();
        profileFragment = new ProfileFragment();

        setFragmentView(repairFragment);

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        BottomNavigationViewHelper.disableShiftMode(navigation);
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        //if(requestCode == IMG)
//    }

}
