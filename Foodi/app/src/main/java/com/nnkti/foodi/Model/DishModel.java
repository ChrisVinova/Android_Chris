package com.nnkti.foodi.Model;

/**
 * Created by nnkti on 6/18/2017.
 */

public class DishModel {
    private String image;
    private String promotion;
    private String details;
    private String name;

    public DishModel(String name, String image, String promotion, String details) {
        this.name = name;
        this.image = image;
        this.promotion = promotion;
        this.details = details;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPromotion() {
        return promotion;
    }

    public void setPromotion(String promotion) {
        this.promotion = promotion;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
