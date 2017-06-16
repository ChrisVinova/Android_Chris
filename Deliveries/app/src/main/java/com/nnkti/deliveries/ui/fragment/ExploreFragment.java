package com.nnkti.deliveries.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatRatingBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nnkti.deliveries.MainActivity;
import com.nnkti.deliveries.Model.Dish;
import com.nnkti.deliveries.Model.ExploreModel;
import com.nnkti.deliveries.adapter.DishAdapter;
import com.nnkti.deliveries.R;
import com.nnkti.deliveries.adapter.ExploreAdapter;
import com.nnkti.deliveries.data.DataDummy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nnkti on 6/14/2017.
 */

public class ExploreFragment extends Fragment {
    private RecyclerView rvExplore;
    private ExploreAdapter exploreAdapter;
    public static ExploreFragment newInstance(){
        ExploreFragment fragment = new ExploreFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.explore_fragment,container, false);
        ((MainActivity) getActivity()).setTitle("Explore");
        rvExplore = (RecyclerView) view.findViewById(R.id.rv_explore);
        exploreAdapter = new ExploreAdapter(DataDummy.getExploreModel(),getContext());
        rvExplore.setAdapter(exploreAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rvExplore.setLayoutManager(linearLayoutManager);
        return view;
    }
}
