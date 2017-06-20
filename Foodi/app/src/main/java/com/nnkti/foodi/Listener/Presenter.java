package com.nnkti.foodi.Listener;

import android.os.AsyncTask;
import android.widget.ProgressBar;

import com.nnkti.foodi.Model.CityGuideModel;
import com.nnkti.foodi.Model.DishModel;
import com.nnkti.foodi.Model.MagazineModel;
import com.nnkti.foodi.R;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by nnkti on 6/20/2017.
 */

public class Presenter implements PresenterInterface.Present {
    private PresenterInterface.View view;
    private ArrayList<DishModel> dishModelArrayList = new ArrayList<>();

    public Presenter(PresenterInterface.View view) {
        this.view = view;
    }

    private class DishRecommendationSyncTask extends AsyncTask<ArrayList<DishModel>, Integer, ArrayList<DishModel>> {

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
                view.setProgress(values[0]);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            view.showProgressBar();
        }

        @Override
        protected void onPostExecute(ArrayList<DishModel> dishModelArrayList) {
            super.onPostExecute(dishModelArrayList);
            view.hidePb();
            view.sendDishRecommendationList(dishModelArrayList);
        }

        @Override
        protected ArrayList<DishModel> doInBackground(ArrayList<DishModel>... params) {
            for (int i = 1; i<=100; i++){
                try {
                    Thread.sleep(40);
                    publishProgress(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            dishModelArrayList.add(
                    new DishModel("Sandwich",
                            "http://www.earlofsandwichusa.com/wp-content/uploads/2016/05/Sandwich_Veggie-min.jpg",
                            "25% off for a table for two",
                            "Dinner 25% off, and only 68USD/each in Solois Coffee"));
            dishModelArrayList.add(
                    new DishModel("Sandwich",
                            "http://www.earlofsandwichusa.com/wp-content/uploads/2016/05/Sandwich_Veggie-min.jpg",
                            "25% off for a table for two",
                            "Dinner 25% off, and only 68USD/each in Solois Coffee"));
            dishModelArrayList.add(
                    new DishModel("Sandwich",
                            "http://www.earlofsandwichusa.com/wp-content/uploads/2016/05/Sandwich_Veggie-min.jpg",
                            "25% off for a table for two",
                            "Dinner 25% off, and only 68USD/each in Solois Coffee"));
            dishModelArrayList.add(
                    new DishModel("Sandwich",
                            "http://www.earlofsandwichusa.com/wp-content/uploads/2016/05/Sandwich_Veggie-min.jpg",
                            "25% off for a table for two",
                            "Dinner 25% off, and only 68USD/each in Solois Coffee"));
            dishModelArrayList.add(
                    new DishModel("Sandwich",
                            "http://www.earlofsandwichusa.com/wp-content/uploads/2016/05/Sandwich_Veggie-min.jpg",
                            "25% off for a table for two",
                            "Dinner 25% off, and only 68USD/each in Solois Coffee"));
            return dishModelArrayList;
        }
    }

    @Override
    public void createDishRecommendationList() {
        DishRecommendationSyncTask dishRecommendationSyncTask = new DishRecommendationSyncTask();
        dishRecommendationSyncTask.execute();
    }

    @Override
    public void createCityGuideList() {
        ArrayList<CityGuideModel> cityGuideModelArrayList = new ArrayList<>();
        cityGuideModelArrayList.add(new CityGuideModel("Awesome Drinks",
                "https://www.tesco.com/groceries/MarketingContent/Sites/Retail/superstore/mercury/P/i/departments/drinks/wk32/row1-Fresh-juices.jpg"));
        cityGuideModelArrayList.add(new CityGuideModel("Healthy and Green",
                "https://www.usnews.com/dims4/USNEWS/30a0132/2147483647/crop/417x274%2B0%2B0/resize/640x420/quality/85/?url=%2Fcmsmedia%2F6c%2F2550011a7502d0b08da461151ab8c6%2F44359Slideshow_GreenSmoothie_120710.jpg"));
        view.sendCityGuideList(cityGuideModelArrayList);
    }

    @Override
    public void createMagazineList() {
        ArrayList<MagazineModel> magazineModelArrayList = new ArrayList<>();
        magazineModelArrayList.add(new MagazineModel("Barbecue Party Tips For A Truly Amazing Event",
                "Via Cookbook | An online magazine for those who cook",
                Calendar.getInstance(),
                "http://cdn.inquisitr.com/wp-content/uploads/2016/05/barbecue-month-Alexander-Raths.jpg"
        ));
        magazineModelArrayList.add(new MagazineModel("Barbecue Party Tips For A Truly Amazing Event",
                "Via Cookbook | An online magazine for those who cook",
                Calendar.getInstance(),
                "http://cdn.inquisitr.com/wp-content/uploads/2016/05/barbecue-month-Alexander-Raths.jpg"
        ));
        view.sendMagazineList(magazineModelArrayList);
    }
}
