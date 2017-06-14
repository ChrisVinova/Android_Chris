package com.nnkti.deliveries;

/**
 * Created by nnkti on 6/13/2017.
 */

public class Dish {
    private String dName;
    private String dOrigin;
    public Dish(String name, String origin){
        dName = name;
        dOrigin = origin;
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
