package com.nnkti.deliveries.data;

import com.nnkti.deliveries.Model.Dish;
import com.nnkti.deliveries.Model.ExploreModel;
import com.nnkti.deliveries.Model.LeftDrawerModel;
import com.nnkti.deliveries.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nnkti on 6/15/2017.
 */

public class DataDummy {
    private static ArrayList<Dish> mDish;

    public static List<LeftDrawerModel> getLefts() {
        List<LeftDrawerModel> list = new ArrayList<>();
        list.add(new LeftDrawerModel(R.drawable.ic_shopping_cart_black_24dp, "Deliverires"));
        list.get(0).setSelected(true);
        list.add(new LeftDrawerModel(R.drawable.ic_explore_black_24dp, "Explore"));
        list.add(new LeftDrawerModel(R.drawable.ic_history_black_24dp, "Order history"));
        list.add(new LeftDrawerModel(R.drawable.ic_people_outline_black_24dp, "Contributions"));
        list.add(new LeftDrawerModel(R.drawable.ic_build_black_24dp, "Help & feedback"));

        return list;
    }

    public static List<Dish> getDish() {
        mDish = new ArrayList<>();
        mDish.add(new Dish("Chicken", "America","http://del.h-cdn.co/assets/15/51/1450278988-honey-soy-chicken.jpg"));
        mDish.add(new Dish("Spagetti", "Italian","http://del.h-cdn.co/assets/15/51/1450278988-honey-soy-chicken.jpg"));
        mDish.add(new Dish("Rice", "VN","http://del.h-cdn.co/assets/15/51/1450278988-honey-soy-chicken.jpg"));
        mDish.add(new Dish("Pho", "VN","http://del.h-cdn.co/assets/15/51/1450278988-honey-soy-chicken.jpg"));
        mDish.add(new Dish("Banh xeo", "VN","http://del.h-cdn.co/assets/15/51/1450278988-honey-soy-chicken.jpg"));
        mDish.add(new Dish("Beef steak", "Italian","http://del.h-cdn.co/assets/15/51/1450278988-honey-soy-chicken.jpg"));
        mDish.add(new Dish("Cappuchino", "Italian","http://del.h-cdn.co/assets/15/51/1450278988-honey-soy-chicken.jpg"));
        mDish.add(new Dish("Americano", "America","http://del.h-cdn.co/assets/15/51/1450278988-honey-soy-chicken.jpg"));
        mDish.add(new Dish("Beef steak", "Italian","http://del.h-cdn.co/assets/15/51/1450278988-honey-soy-chicken.jpg"));
        mDish.add(new Dish("Banh xeo", "VN","http://del.h-cdn.co/assets/15/51/1450278988-honey-soy-chicken.jpg"));
        mDish.add(new Dish("Beef steak", "Italian","http://del.h-cdn.co/assets/15/51/1450278988-honey-soy-chicken.jpg"));
        mDish.add(new Dish("Spagetti", "Italian","http://del.h-cdn.co/assets/15/51/1450278988-honey-soy-chicken.jpg"));
        mDish.add(new Dish("Rice", "VN","http://del.h-cdn.co/assets/15/51/1450278988-honey-soy-chicken.jpg"));
        mDish.add(new Dish("Pho", "VN","http://del.h-cdn.co/assets/15/51/1450278988-honey-soy-chicken.jpg"));
        mDish.add(new Dish("Beef steak", "Italian","http://del.h-cdn.co/assets/15/51/1450278988-honey-soy-chicken.jpg"));
        return mDish;
    }

    public static List<ExploreModel> getExploreModel() {
        List<ExploreModel> exploreModelList = new ArrayList<>();
        exploreModelList.add(new ExploreModel("Casual Lunch",mDish.get(1),5f,mDish.get(0),4.5f));
        exploreModelList.add(new ExploreModel("Winter warmers",mDish.get(2),4.5f,mDish.get(3),4.5f));
        exploreModelList.add(new ExploreModel("Dinner",mDish.get(5),4f,mDish.get(4),4.5f));
        exploreModelList.add(new ExploreModel("Snack",mDish.get(6),5f,mDish.get(7),5f));
        exploreModelList.add(new ExploreModel("Roasted",mDish.get(8),4.6f,mDish.get(9),3f));

        return exploreModelList;
    }
}
