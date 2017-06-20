package com.nnkti.foodi.Listener;

import com.nnkti.foodi.Model.CityGuideModel;
import com.nnkti.foodi.Model.DishModel;
import com.nnkti.foodi.Model.MagazineModel;

import java.util.ArrayList;

/**
 * Created by nnkti on 6/20/2017.
 */

public interface PresenterInterface {
    interface View{
        void sendDishRecommendationList(ArrayList<DishModel> dishModelArrayList);
        void sendCityGuideList(ArrayList<CityGuideModel> cityGuideModelArrayList);
        void sendMagazineList(ArrayList<MagazineModel> magazineModelArrayList);
        void showProgressBar();
        void setProgress(int x);
        void hidePb();
    }
    interface Present{
        void createDishRecommendationList();
       void createCityGuideList();
        void createMagazineList();
    }
}
