package com.nnkti.deliveries.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatRatingBar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.nnkti.deliveries.MainActivity;
import com.nnkti.deliveries.Model.Dish;
import com.nnkti.deliveries.Model.ExploreModel;
import com.nnkti.deliveries.R;

import java.util.List;

import static com.nnkti.deliveries.R.id.ivDish1;

/**
 * Created by nnkti on 6/16/2017.
 */

public class ExploreAdapter extends RecyclerView.Adapter<ExploreAdapter.ExploreViewHolder> {
    private List<ExploreModel> exploreModelList;
    private Context context;
    private LayoutInflater layoutInflater;

    public ExploreAdapter(List<ExploreModel> exploreModelList, Context context) {
        this.exploreModelList = exploreModelList;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public ExploreViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.item_explore, parent, false);
        return new ExploreAdapter.ExploreViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ExploreViewHolder holder, int position) {
        ExploreModel exploreModel = exploreModelList.get(position);
        holder.bind(position);

    }

    @Override
    public int getItemCount() {
        return exploreModelList.size();
    }


    public class ExploreViewHolder extends RecyclerView.ViewHolder{
        private TextView tvCategoryName;
        private TextView tvDish1Name;
        private TextView tvDish2Name;
        private TextView tvDish1Origin;
        private TextView tvDish2Origin;
        private TextView tvDish1Score;
        private TextView tvDish2Score;
        private ImageView ivDish1;
        private ImageView ivDish2;
        private RatingBar ratingBar1 = new RatingBar(context, null, android.R.attr.ratingBarStyleSmall);;
        private RatingBar ratingBar2 = new RatingBar(context, null, android.R.attr.ratingBarStyleSmall);;

        public ExploreViewHolder(View itemView) {
            super(itemView);
            tvCategoryName = (TextView) itemView.findViewById(R.id.tvCategoryName);

            ratingBar1 = (RatingBar) itemView.findViewById(R.id.rbDish1);
            ratingBar2 = (RatingBar) itemView.findViewById(R.id.rbDish2);



            ivDish1 = (ImageView) itemView.findViewById(R.id.ivDish1);
            tvDish1Name = (TextView) itemView.findViewById(R.id.tvDish1Name);
            tvDish1Origin = (TextView) itemView.findViewById(R.id.tvDish1Origin);
            tvDish1Score = (TextView) itemView.findViewById(R.id.tvDish1Score);

            ivDish2 = (ImageView) itemView.findViewById(R.id.ivDish2);
            tvDish2Name = (TextView) itemView.findViewById(R.id.tvDish2Name);
            tvDish2Origin = (TextView) itemView.findViewById(R.id.tvDish2Origin);
            tvDish2Score = (TextView) itemView.findViewById(R.id.tvDish2Score);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ExploreModel exploreModel= exploreModelList.get(getAdapterPosition());
                    Toast.makeText(context, exploreModel.getCategoryName(), Toast.LENGTH_SHORT).show();
                }
            });
        }

        public void bind(int position) {
            final ExploreModel item = exploreModelList.get(position);
            tvCategoryName.setText(item.getCategoryName());

            //------------------First dish bind
            Glide.with(context).load(item.getDish1().getdImage()).into(ivDish1);
            tvDish1Name.setText(item.getDish1().getdName());
            tvDish1Origin.setText(item.getDish1().getdOrigin());
            tvDish1Score.setText(Float.toString(item.getPoint1()));

            //ratingBar1
            ratingBar1.setRating(exploreModelList.get(position).getPoint1());

            //-------------------Second dish bind
            Glide.with(context).load(item.getDish2().getdImage()).into(ivDish2);
            tvDish2Name.setText(item.getDish2().getdName());
            tvDish2Origin.setText(item.getDish2().getdOrigin());
            tvDish2Score.setText(Float.toString(item.getPoint2()));
            //ratingBar2
            ratingBar2.setRating(exploreModelList.get(position).getPoint2());
        }
    }
}
