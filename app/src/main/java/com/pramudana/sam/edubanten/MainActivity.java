package com.pramudana.sam.edubanten;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.pramudana.sam.edubanten.fragment.ChartFragment;
import com.pramudana.sam.edubanten.fragment.HomeFragment;
import com.pramudana.sam.edubanten.fragment.InfoFragment;
import com.pramudana.sam.edubanten.fragment.ProfileFragment;
import com.pramudana.sam.edubanten.fragment.StepFragment;
import com.pramudana.sam.edubanten.helper.MyFuction;

public class MainActivity extends MyFuction {



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();


            switch (item.getItemId()) {
                case R.id.navigation_home:
                    transaction.replace(R.id.content, new HomeFragment()).commit();
                    return true;
                case R.id.navigation_chart:
                    transaction.replace(R.id.content, new ChartFragment()).commit();
                    return true;
                case R.id.navigation_profile:
                    transaction.replace(R.id.content, new ProfileFragment()).commit();
                    return true;
                case R.id.navigation_step:
                    transaction.replace(R.id.content, new StepFragment()).commit();
                    return true;
                case R.id.navigation_info:
                    transaction.replace(R.id.content, new InfoFragment()).commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.replace(R.id.content, new HomeFragment()).commit();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    public void onBackPressed() {
        keluar();
        super.onBackPressed();
    }
}
