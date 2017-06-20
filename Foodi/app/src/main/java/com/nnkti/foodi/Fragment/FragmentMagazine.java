package com.nnkti.foodi.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.nnkti.foodi.Adapter.MagazineAdapter;
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

public class FragmentMagazine extends Fragment implements PresenterInterface.View{
    private RecyclerView rvMagazine;
    private MagazineAdapter magazineAdapter;
    private ProgressBar progressBar;
    public static FragmentMagazine newInstance(){
        FragmentMagazine fragment = new FragmentMagazine();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_magazine,container, false);
        Presenter presenter = new Presenter(FragmentMagazine.this);
        //Hot today
        rvMagazine = (RecyclerView) view.findViewById(R.id.rvMagazine);
        magazineAdapter= new MagazineAdapter(getContext());
        presenter.createMagazineList();
        rvMagazine.setAdapter(magazineAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rvMagazine.setLayoutManager(linearLayoutManager);

        return view;
    }

    @Override
    public void sendDishRecommendationList(ArrayList<DishModel> dishModelArrayList) {

    }

    @Override
    public void sendCityGuideList(ArrayList<CityGuideModel> cityGuideModelArrayList) {

    }

    @Override
    public void sendMagazineList(ArrayList<MagazineModel> magazineModelArrayList) {
         magazineAdapter.setList(magazineModelArrayList);
    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void setProgress(int x) {

    }

    @Override
    public void hidePb() {

    }
}
