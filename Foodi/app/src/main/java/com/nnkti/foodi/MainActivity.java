package com.nnkti.foodi;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.nnkti.foodi.Constant.Constant;
import com.nnkti.foodi.Fragment.FragmentMagazine;
import com.nnkti.foodi.Fragment.FragmentSelect;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            switch (item.getItemId()) {
                case R.id.navigation_select:
                    editor.putString(Constant.RECENTLY_CLICKED,"Select");
                    editor.commit();
                    changeFragment(R.id.content, FragmentSelect.newInstance());
                    return true;
                case R.id.navigation_store:
                    editor.putString(Constant.RECENTLY_CLICKED,"Store");
                    editor.commit();

                    return true;
                case R.id.navigation_magazine:
                    editor.putString(Constant.RECENTLY_CLICKED,"Magazine");
                    editor.commit();
                    changeFragment(R.id.content, FragmentMagazine.newInstance());
                    return true;
                case R.id.navigation_cart:
                    editor.putString(Constant.RECENTLY_CLICKED,"Cart");
                    editor.commit();

                    return true;
                case R.id.navigation_profile:
                    editor.putString(Constant.RECENTLY_CLICKED,"Profile");
                    editor.commit();

                    return true;
            }
            return false;
        }

    };
    public void changeFragment(int resId, Fragment fragment){
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(resId, fragment);
        transaction.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        changeFragment(R.id.content, FragmentSelect.newInstance());
        //Shared Preference

        sharedPreferences = getPreferences(Context.MODE_PRIVATE);
        Toast.makeText(this,sharedPreferences.getString(Constant.RECENTLY_CLICKED,"failed lul"), Toast.LENGTH_SHORT).show();
        //Botton Navigation View
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
