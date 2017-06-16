package com.nnkti.deliveries.Model;

/**
 * Created by nnkti on 6/16/2017.
 */

public class ExploreModel {
    private String categoryName;
    private Dish dish1;
    private float point1;
    private Dish dish2;
    private float point2;

    public ExploreModel(String categoryName, Dish dish1, float point1, Dish dish2, float point2) {
        this.categoryName = categoryName;
        this.dish1 = dish1;
        this.point1 = point1;
        this.dish2 = dish2;
        this.point2 = point2;
    }
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Dish getDish1() {
        return dish1;
    }

    public void setDish1(Dish dish1) {
        this.dish1 = dish1;
    }

    public float getPoint1() {
        return point1;
    }

    public void setPoint1(float point1) {
        this.point1 = point1;
    }

    public Dish getDish2() {
        return dish2;
    }

    public void setDish2(Dish dish2) {
        this.dish2 = dish2;
    }

    public float getPoint2() {
        return point2;
    }

    public void setPoint2(float point2) {
        this.point2 = point2;
    }
}
