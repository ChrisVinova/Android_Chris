package com.nnkti.deliveries.Model;

/**
 * Created by nnkti on 6/13/2017.
 */

public class Dish {
    private String dName;
    private String dOrigin;
    private String dImage;

    public Dish(String name, String origin,String image){
        dName = name;
        dOrigin = origin;
        dImage = image;
    }
    public String getdImage() {
        return dImage;
    }

    public void setdImage(String dImage) {
        this.dImage = dImage;
    }



    public String getdName() {
        return dName;
    }
    public String getdOrigin() {
        return dOrigin;
    }

    public void setdName(String name) {
        dName = name;
    }
    public void setdOrigin(String origin) {
        dOrigin = origin;
    }

}
