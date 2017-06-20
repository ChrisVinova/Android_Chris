package com.nnkti.foodi.Fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.nnkti.foodi.Adapter.CityGuideAdapter;
import com.nnkti.foodi.Adapter.DishAdapter;
import com.nnkti.foodi.Listener.Presenter;
import com.nnkti.foodi.Listener.PresenterInterface;
import com.nnkti.foodi.Model.CityGuideModel;
import com.nnkti.foodi.Model.DishModel;
import com.nnkti.foodi.Model.MagazineModel;
import com.nnkti.foodi.R;

import java.util.ArrayList;

/**
 * Created by nnkti on 6/18/2017.
 */

public class FragmentSelect extends Fragment implements PresenterInterface.View {
    private RecyclerView rvDishRecommendation;
    private RecyclerView rvCityGuide;
    private DishAdapter dishAdapter;
    private CityGuideAdapter cityGuideAdapter;
    private ProgressBar progressBar;
    private TextView tvStatus;

    public static FragmentSelect newInstance() {
        FragmentSelect fragment = new FragmentSelect();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_select, container, false);
        tvStatus = (TextView) view.findViewById(R.id.tvStatus);
        Presenter presenter = new Presenter(FragmentSelect.this);
        progressBar = (ProgressBar) view.findViewById(R.id.pbUpdater);
        progressBar.setVisibility(View.GONE);
        //Hot today
        rvDishRecommendation = (RecyclerView) view.findViewById(R.id.rvDishRecommendation);
        dishAdapter = new DishAdapter(getContext());
        presenter.createDishRecommendationList();
        rvDishRecommendation.setAdapter(dishAdapter);
        LinearLayoutManager linearLayoutManagerDishRecommendation = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        rvDishRecommendation.setLayoutManager(linearLayoutManagerDishRecommendation);

        //City guide
        rvCityGuide = (RecyclerView) view.findViewById(R.id.rvCityGuide);
        cityGuideAdapter = new CityGuideAdapter(getContext());
        presenter.createCityGuideList();
        rvCityGuide.setAdapter(cityGuideAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        rvCityGuide.setLayoutManager(linearLayoutManager);
        return view;
    }

    @Override
    public void sendDishRecommendationList(ArrayList<DishModel> dishModelArrayList) {
        dishAdapter.setDishModelList(dishModelArrayList);
    }

    @Override
    public void sendCityGuideList(ArrayList<CityGuideModel> cityGuideModelArrayList) {
        cityGuideAdapter.setCityGuideModelList(cityGuideModelArrayList);
    }

    @Override
    public void sendMagazineList(ArrayList<MagazineModel> magazineModelArrayList) {

    }

    @Override
    public void showProgressBar() {
        progressBar.setMax(100);
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void setProgress(int x) {
        tvStatus.setText(progressBar.getProgress() + "/" + progressBar.getMax());
        progressBar.setProgress(x);
    }

    @Override
    public void hidePb() {
        tvStatus.setVisibility(View.INVISIBLE);
        if (progressBar != null)
            progressBar.setVisibility(View.GONE);
    }
}
