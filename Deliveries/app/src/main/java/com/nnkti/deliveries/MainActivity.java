package com.nnkti.deliveries;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nnkti.deliveries.data.DataDummy;
import com.nnkti.deliveries.ui.fragment.DeliveriesFragment;
import com.nnkti.deliveries.ui.fragment.ExploreFragment;
import com.nnkti.deliveries.ui.fragment.LeftFragment;

import static com.nnkti.deliveries.R.id.fab;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    DrawerLayout drawer;
    RelativeLayout navigationLeft;
    RelativeLayout navigationRight;
    TextView tvTitle;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout_left);
        //Floating button
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Search button clicked", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DataDummy.getDish();

        navigationLeft = (RelativeLayout) findViewById(R.id.nav_view_left);
        navigationRight = (RelativeLayout) findViewById(R.id.nav_view_right);

        ImageButton btnLeft = (ImageButton) findViewById(R.id.toggleLeftDrawer);
        ImageButton btnRight = (ImageButton) findViewById(R.id.toggleRightDrawer);

        btnLeft.setOnClickListener(this);
        btnRight.setOnClickListener(this);

        drawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        changeFragment(R.id.container, DeliveriesFragment.newInstance());
        changeFragment(R.id.nav_view_left, LeftFragment.newInstance());
    }

    public void fabHide(){
        if (fab != null)
            fab.hide();
    }
    public void fabUnhide(){
        if (fab != null)
            fab.show();
    }

    public void setTitle(String title){
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvTitle.setText(title);
    }

    public void changeFragment(int resId, Fragment fragment){
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(resId, fragment);
        transaction.commit();
    }

    public void closeDrawer(){
        if (drawer == null)
            return;
        drawer.closeDrawers();
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

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // The action bar home/up action should open or close the drawer.
//        switch (item.getItemId()) {
//            case R.id.nav_deliveries:
//                Toast.makeText(this, "Deliveries menu pressed", Toast.LENGTH_SHORT).show();
//                changeFragment(R.id.container, DeliveriesFragment.newInstance());
//                return true;
//            case R.id.nav_explore:
//                Toast.makeText(this, "Explore menu pressed", Toast.LENGTH_SHORT).show();
//                changeFragment(R.id.container, DeliveriesFragment.newInstance());
//                return true;
//            default:
//                Toast.makeText(this, "other menus pressed", Toast.LENGTH_SHORT).show();
//                return super.onOptionsItemSelected(item);
//        }
//    }
}

