package com.nnkti.deliveries.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.nnkti.deliveries.Model.Dish;
import com.nnkti.deliveries.R;

import java.util.List;

/**
 * Created by nnkti on 6/13/2017.
 */

public class DishAdapter extends RecyclerView.Adapter<DishAdapter.DishViewHolder> {
    private List<Dish> mDishes;
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public DishAdapter(Context context, List<Dish> datas) {
        mContext = context;
        mDishes = datas;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public DishViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.item_dish, parent, false);
        return new DishViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DishViewHolder holder, int position) {
        //get Dish in mDish via position
        Dish dish = mDishes.get(position);

        //bind data to viewholder
        holder.tvName.setText(dish.getdName());
        holder.tvOrigin.setText(dish.getdOrigin());
        Glide.with(mContext).load(dish.getdImage()).into(holder.ivDish);
    }
 
    @Override
    public int getItemCount() {
        return mDishes.size();
    }
    
    class DishViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName;
        private TextView tvOrigin;
        private ImageView ivDish;
        public DishViewHolder(View itemView) {
            super(itemView);
            ivDish = (ImageView) itemView.findViewById(R.id.ivDish);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvOrigin = (TextView) itemView.findViewById(R.id.tv_origin);

            itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dish mDish = mDishes.get(getAdapterPosition());
                Toast.makeText(mContext, mDish.getdName(), Toast.LENGTH_SHORT).show();
            }
        });
        }
    }
}
