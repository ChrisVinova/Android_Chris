package com.nnkti.deliveries.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.nnkti.deliveries.adapter.LeftDrawerAdapter;
import com.nnkti.deliveries.MainActivity;
import com.nnkti.deliveries.Model.LeftDrawerModel;
import com.nnkti.deliveries.R;
import com.nnkti.deliveries.data.DataDummy;
import com.nnkti.deliveries.listener.OnClickListener;

/**
 * Created by nnkti on 6/15/2017.
 */

public class LeftFragment extends Fragment implements OnClickListener {
    private RecyclerView recyclerView;
    private LeftDrawerAdapter leftDrawerAdapter;
    public static LeftFragment newInstance() {
        LeftFragment fragment = new LeftFragment();

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_left, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.rvLeftDrawer);
        ImageView imageView = (ImageView) view.findViewById(R.id.ivHeader);
        Glide.with(this).load("http://www.trend-chaser.com/wp-content/uploads/sites/7/2016/11/variety.jpg").into(imageView);


        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LinearLayoutManager linearLayoutManager;
        linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        leftDrawerAdapter= new LeftDrawerAdapter(DataDummy.getLefts(),getContext());
        recyclerView.setAdapter(leftDrawerAdapter);
        leftDrawerAdapter.setListener(this);
    }

    @Override
    public void clickListener(LeftDrawerModel model, int position) {
        switch (position) {
            case 0:
                ((MainActivity) getActivity()).changeFragment(R.id.container, DeliveriesFragment.newInstance());
                //Unhide fab
                ((MainActivity) getActivity()).fabUnhide();
                Toast.makeText(getContext(),"Deliveries Fragment",Toast.LENGTH_SHORT).show();
                break;
            case 1:
                ((MainActivity) getActivity()).changeFragment(R.id.container, ExploreFragment.newInstance());
                //Hide search button
                ((MainActivity) getActivity()).fabHide();
                Toast.makeText(getContext(),"Explore fragment",Toast.LENGTH_SHORT).show();
                break;
        }

        //model.setSelected(true);
        ((MainActivity) getActivity()).closeDrawer();
    }
}
