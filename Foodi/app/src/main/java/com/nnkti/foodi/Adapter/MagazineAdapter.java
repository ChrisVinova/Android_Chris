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
import com.nnkti.foodi.Model.MagazineModel;
import com.nnkti.foodi.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by nnkti on 6/19/2017.
 */

public class MagazineAdapter extends RecyclerView.Adapter<MagazineAdapter.MagazineViewHolder> {
    private ArrayList<MagazineModel> magazineModelList;
    private Context context;
    private LayoutInflater layoutInflater;
    @Override
    public MagazineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = layoutInflater.inflate(R.layout.item_magazine,parent,false);
        return new MagazineAdapter.MagazineViewHolder(item);
    }

    @Override
    public void onBindViewHolder(MagazineViewHolder holder, int position) {
        MagazineModel magazineModel = magazineModelList.get(position);
        Glide.with(context).load(magazineModel.getImage()).into(holder.ivMagazineItem);
        holder.tvTitleItem.setText(magazineModel.getTitle());
        holder.tvSourceItem.setText(magazineModel.getSource());

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        String date = format.format(magazineModel.getDate().getTime());
        holder.tvDateItem.setText(date);
    }

    @Override
    public int getItemCount() {
        return magazineModelList == null? 0 : magazineModelList.size();
    }

    public MagazineAdapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    public void setList(ArrayList<MagazineModel> magazineModelList){
        this.magazineModelList = magazineModelList;
        notifyDataSetChanged();
    }

    class MagazineViewHolder extends RecyclerView.ViewHolder{
        TextView tvTitleItem;
        TextView tvSourceItem;
        TextView tvDateItem;
        ImageView ivMagazineItem;

        public MagazineViewHolder(View itemView) {
            super(itemView);
            ivMagazineItem = (ImageView) itemView.findViewById(R.id.ivMagazineItem);
            tvTitleItem = (TextView) itemView.findViewById(R.id.tvTitleItem);
            tvSourceItem = (TextView) itemView.findViewById(R.id.tvSourceItem);
            tvDateItem = (TextView) itemView.findViewById(R.id.tvDateItem);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MagazineModel magazineModel= magazineModelList.get(getAdapterPosition());
                    Toast.makeText(context, magazineModel.getTitle(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
