package com.nnkti.foodi.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.nnkti.foodi.Model.CityGuideModel;
import com.nnkti.foodi.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nnkti on 6/18/2017.
 */

public class CityGuideAdapter extends RecyclerView.Adapter<CityGuideAdapter.CityGuideViewHolder> {
    private List<CityGuideModel> cityGuideModelList;
    private Context context;
    private LayoutInflater layoutInflater;

    public CityGuideAdapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    public void setCityGuideModelList(ArrayList<CityGuideModel> cityGuideModelList) {
        this.cityGuideModelList = cityGuideModelList;
        notifyDataSetChanged();
    }

    @Override
    public CityGuideViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.item_city_guide, parent, false);
        return new CityGuideViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CityGuideViewHolder holder, int position) {
        //get cityGuideModel via position

        CityGuideModel cityGuideModel = cityGuideModelList.get(position);

        //bind data to viewholder
        Glide.with(context).load(cityGuideModel.getImage()).into(holder.ivCityGuideItem);
        holder.tvCityGuideItem.setText(cityGuideModel.getDetails());
    }

    @Override
    public int getItemCount() {
        return cityGuideModelList == null ? 0 : cityGuideModelList.size();
    }

    class CityGuideViewHolder extends RecyclerView.ViewHolder {
        private TextView tvCityGuideItem;
        private ImageView ivCityGuideItem;

        public CityGuideViewHolder(View itemView) {
            super(itemView);
            ivCityGuideItem = (ImageView) itemView.findViewById(R.id.ivCityGuideItem);
            tvCityGuideItem = (TextView) itemView.findViewById(R.id.tvCityGuideItem);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CityGuideModel cityGuideModel = cityGuideModelList.get(getAdapterPosition());
                    Toast.makeText(context, cityGuideModel.getDetails(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
