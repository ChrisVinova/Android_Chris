package com.nnkti.deliveries.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nnkti.deliveries.Dish;
import com.nnkti.deliveries.DishAdapter;
import com.nnkti.deliveries.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nnkti on 6/14/2017.
 */

public class DeliveriesFragment extends Fragment {
    private RecyclerView rvDishes;
    private DishAdapter mDishAdapter;
    public static DeliveriesFragment newInstance(){
        DeliveriesFragment fragment = new DeliveriesFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.deliveries_fragment,container, false);
        rvDishes = (RecyclerView) view.findViewById(R.id.rv_dishes);
        List<Dish> mDish = new ArrayList<>();
        mDish.add(new Dish("Chicken","America"));
        mDish.add(new Dish("Spagetti","Italian"));
        mDish.add(new Dish("Rice","VN"));
        mDish.add(new Dish("Pho","VN"));
        mDish.add(new Dish("Banh xeo","VN"));
        mDish.add(new Dish("Beef steak","Italian"));
        mDish.add(new Dish("Cappuchino","Italian"));
        mDish.add(new Dish("Americano","America"));
        mDish.add(new Dish("Beef steak","Italian"));
        mDish.add(new Dish("Banh xeo","VN"));
        mDish.add(new Dish("Beef steak","Italian"));
        mDish.add(new Dish("Spagetti","Italian"));
        mDish.add(new Dish("Rice","VN"));
        mDish.add(new Dish("Pho","VN"));
        mDish.add(new Dish("Beef steak","Italian"));

        mDishAdapter = new DishAdapter(getContext(), mDish);
        rvDishes.setAdapter(mDishAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rvDishes.setLayoutManager(linearLayoutManager);


        return view;
    }
}
