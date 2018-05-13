package com.example.werepair;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

public class BottomActivityTest extends AppCompatActivity {

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
        setContentView(R.layout.activity_bottom_test);

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

}
