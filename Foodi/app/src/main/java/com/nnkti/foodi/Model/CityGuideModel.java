package com.nnkti.foodi.Model;

/**
 * Created by nnkti on 6/19/2017.
 */

public class CityGuideModel {
    private String details;
    private String image;

    public CityGuideModel(String details, String image) {
        this.details = details;
        this.image = image;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
