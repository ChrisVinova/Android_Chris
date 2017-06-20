package com.nnkti.foodi.Model;

import java.util.Calendar;

/**
 * Created by nnkti on 6/19/2017.
 */

public class MagazineModel {
    private String title;
    private String source;
    private Calendar date;
    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public MagazineModel(String title, String source, Calendar date, String image) {
        this.title = title;
        this.source = source;
        this.date = date;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }
}
