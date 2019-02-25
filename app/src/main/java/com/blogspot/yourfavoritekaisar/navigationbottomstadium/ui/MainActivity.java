package com.blogspot.yourfavoritekaisar.navigationbottomstadium.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.blogspot.yourfavoritekaisar.navigationbottomstadium.R;
import com.blogspot.yourfavoritekaisar.navigationbottomstadium.ui.favorite.FavoriteFragment;
import com.blogspot.yourfavoritekaisar.navigationbottomstadium.ui.stadium.FragmentStadium;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.fl_container)
    FrameLayout flContainer;
    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_stadium:
                    FragmentStadium fragmentStadium = new FragmentStadium();
                    loadFragment(fragmentStadium);
                    return true;
                case R.id.navigation_favorite:
                    FavoriteFragment favoriteFragment = new FavoriteFragment();
                    loadFragment(favoriteFragment);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        getSupportActionBar().setTitle("Stadium");

        FragmentStadium fragmentStadium = new FragmentStadium();

    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        // MENGGANTI FRAME LAYOUT DENGAN FRAGMENT
        transaction.replace(R.id.fl_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


}
