package com.nnkti.deliveries;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.nnkti.deliveries.ui.fragment.DeliveriesFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    DrawerLayout drawer;
    RelativeLayout navigationLeft;
    RelativeLayout navigationRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Search button clicked", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout_left);
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.setDrawerListener(toggle);
        navigationLeft = (RelativeLayout) findViewById(R.id.nav_view_left);
        navigationRight = (RelativeLayout) findViewById(R.id.nav_view_right);

        Button btnLeft = (Button) findViewById(R.id.toggleLeftDrawer);
        Button btnRight = (Button) findViewById(R.id.toggleRightDrawer);

        btnLeft.setOnClickListener(this);
        btnRight.setOnClickListener(this);

        changeFragment(R.id.container, DeliveriesFragment.newInstance());
    }

    private void changeFragment(int resId, Fragment fragment){
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(resId, fragment);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_left);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.toggleLeftDrawer){
            drawer.openDrawer(navigationLeft);
        }else if (v.getId() == R.id.toggleRightDrawer){
            drawer.openDrawer(navigationRight);
        }
    }
}

