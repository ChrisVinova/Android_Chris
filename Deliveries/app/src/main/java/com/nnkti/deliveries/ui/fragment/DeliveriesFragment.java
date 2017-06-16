package com.nnkti.deliveries.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nnkti.deliveries.MainActivity;
import com.nnkti.deliveries.adapter.DishAdapter;
import com.nnkti.deliveries.R;
import com.nnkti.deliveries.data.DataDummy;

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

        ((MainActivity) getActivity()).setTitle("Deliveries");
        rvDishes = (RecyclerView) view.findViewById(R.id.rv_dishes);

        mDishAdapter = new DishAdapter(getContext(), DataDummy.getDish());
        rvDishes.setAdapter(mDishAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rvDishes.setLayoutManager(linearLayoutManager);


        return view;
    }
}
