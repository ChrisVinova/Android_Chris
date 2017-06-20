package com.nnkti.foodi.Adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.nnkti.foodi.Constant.Constant;
import com.nnkti.foodi.Model.DishModel;
import com.nnkti.foodi.R;

import java.util.ArrayList;

/**
 * Created by nnkti on 6/18/2017.
 */

public class DishAdapter extends RecyclerView.Adapter<DishAdapter.DishViewHolder>{
    private ArrayList<DishModel> dishModelList;
    private Context context;
    private LayoutInflater layoutInflater;

    public DishAdapter(Context contextCurrent) {
        context = contextCurrent;
        layoutInflater = LayoutInflater.from(context);
    }

    public void setDishModelList(ArrayList<DishModel> cityGuideModelList){
        this.dishModelList = cityGuideModelList;
        notifyDataSetChanged();
    }

    @Override
    public DishViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.item_dish_recommendation, parent, false);
        return new DishViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DishViewHolder holder, int position) {
        //get Dish in mDish via position
        DishModel dishModel = dishModelList.get(position);

        //bind data to viewholder
        Glide.with(context).load(dishModel.getImage()).into(holder.ivDish);
        holder.tvPromotion.setText(dishModel.getPromotion());
        holder.tvDetails.setText(dishModel.getDetails());
    }

    @Override
    public int getItemCount() {
        return dishModelList==null ? 0 :dishModelList.size();
    }

    public int getAdapterPosition(){
        return getAdapterPosition();
    }

    class DishViewHolder extends RecyclerView.ViewHolder {
        private TextView tvPromotion;
        private TextView tvDetails;
        private ImageView ivDish;
        public DishViewHolder(View itemView) {
            super(itemView);
            ivDish = (ImageView) itemView.findViewById(R.id.ivDish);
            tvPromotion = (TextView) itemView.findViewById(R.id.tvPromotion);
            tvDetails = (TextView) itemView.findViewById(R.id.tvDetails);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DishModel dishModel = dishModelList.get(getAdapterPosition());
                    Toast.makeText(context, dishModel.getName(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
