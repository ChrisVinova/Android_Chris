package com.nnkti.deliveries.adapter;

import android.content.Context;
import android.graphics.Typeface;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.nnkti.deliveries.Model.LeftDrawerModel;
import com.nnkti.deliveries.R;
import com.nnkti.deliveries.listener.OnClickListener;

import java.util.List;

/**
 * Created by nnkti on 6/15/2017.
 */

public class LeftDrawerAdapter extends RecyclerView.Adapter<LeftDrawerAdapter.ViewHolder> {
    private List<LeftDrawerModel> leftDrawerList;
    private Context context;
    private LayoutInflater layoutInflater;
    private OnClickListener listener;

    public LeftDrawerAdapter(List<LeftDrawerModel> leftDrawerList, Context context) {
        this.leftDrawerList = leftDrawerList;
        this.context = context;
    }

    public void setListener(OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = layoutInflater.from(context).inflate(R.layout.item_left_drawer, parent, false);
        return new LeftDrawerAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(LeftDrawerAdapter.ViewHolder holder, int position) {
        LeftDrawerModel item = leftDrawerList.get(position);

        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return leftDrawerList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName;
        private ImageView imIcon;

        public ViewHolder(View itemView) {
            super(itemView);

            tvName = (TextView) itemView.findViewById(R.id.tv_name_left_drawer);
            imIcon = (ImageView) itemView.findViewById(R.id.iv_icon);
        }

        public void bind(final int position) {
            final LeftDrawerModel item = leftDrawerList.get(position);
            Glide.with(context).load(item.getIcon()).into(imIcon);

            SpannableStringBuilder builder = new SpannableStringBuilder(item.getName());
            builder.setSpan(new StyleSpan(Typeface.BOLD), 0, item.getName().length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            tvName.setText(builder);

            if (item.isSelected()) {
                //hight light item
                tvName.setTextColor(ContextCompat.getColor(context, R.color.colorAccent));
                tvName.setBackgroundColor(ContextCompat.getColor(context,R.color.cardview_dark_background));
                imIcon.setBackgroundColor(ContextCompat.getColor(context,R.color.cardview_dark_background));
            } else {
                tvName.setTextColor(ContextCompat.getColor(context, R.color.colorPrimaryDark));
                tvName.setBackgroundColor(ContextCompat.getColor(context,R.color.cardview_light_background));
                imIcon.setBackgroundColor(ContextCompat.getColor(context,R.color.cardview_light_background));

            }

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(context, item.getName(), Toast.LENGTH_SHORT).show();

                    if (listener != null) {
                        reset();
                        item.setSelected(true);
                        leftDrawerList.set(position, item);
                        notifyDataSetChanged();
                        listener.clickListener(item, position);
                    }
                }
            });
        }

        private void reset() {
            if (leftDrawerList == null)
                return;

            for (int i = 0; i < leftDrawerList.size(); i++) {
                LeftDrawerModel model = leftDrawerList.get(i);
                model.setSelected(false);
                leftDrawerList.set(i, model);
            }
        }
    }
}
