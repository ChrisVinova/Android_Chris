package com.nnkti.deliveries;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
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
        //inflate view from row_item_dish.xml
        View itemView = mLayoutInflater.inflate(R.layout.row_item_dish, parent, false);
        return new DishViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DishViewHolder holder, int position) {
        //get Dish in mDish via position
        Dish Dish = mDishes.get(position);

        //bind data to viewholder
        holder.tvName.setText(Dish.getdName());
        holder.tvOrigin.setText(Dish.getdOrigin());
    }
 
    @Override
    public int getItemCount() {
        return mDishes.size();
    }
    
    class DishViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName;
        private TextView tvOrigin;
        public DishViewHolder(View itemView) {
            super(itemView);
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
