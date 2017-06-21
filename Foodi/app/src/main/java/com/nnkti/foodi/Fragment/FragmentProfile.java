package com.nnkti.foodi.Fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.nnkti.foodi.R;

import static com.nnkti.foodi.R.id.imageView;

/**
 * Created by nnkti on 6/21/2017.
 */

public class FragmentProfile extends Fragment {
    private ImageView ivProfileBackground;
    private ImageView ivProfile;
    private TextView tvProfile;
    public static FragmentProfile newInstance() {
        FragmentProfile fragment = new FragmentProfile();
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile,container,false);
        ivProfileBackground = (ImageView) view.findViewById(R.id.ivProfileBackground);
        ivProfile = (ImageView) view.findViewById(R.id.ivProfile);
        tvProfile = (TextView) view.findViewById(R.id.tvProfile);
        tvProfile.setText("Doge");
        Glide.with(this.getContext()).load("https://vectr.com/images/tutorials/how-to-use-gradients/linear-gradient-tutorial-example.png").into(ivProfileBackground);
        Glide.with(this.getContext()).load("https://pbs.twimg.com/profile_images/378800000822867536/3f5a00acf72df93528b6bb7cd0a4fd0c.jpeg").into(ivProfile);
//        Glide.with(this.getContext()).load("https://pbs.twimg.com/profile_images/378800000822867536/3f5a00acf72df93528b6bb7cd0a4fd0c.jpeg")
//                .asBitmap().centerCrop().into(new BitmapImageViewTarget(ivProfile) {
//            @Override
//            protected void setResource(Bitmap resource) {
//                RoundedBitmapDrawable circularBitmapDrawable =
//                        RoundedBitmapDrawableFactory.create(getContext().getResources(), resource);
//                circularBitmapDrawable.setCircular(true);
//                ivProfile.setImageDrawable(circularBitmapDrawable);
//            }
//        });
        return view;
    }
}
