package com.nnkti.deliveries.Model;

/**
 * Created by nnkti on 6/15/2017.
 */

public class LeftDrawerModel {
    private int icon;
    private String name;
    private boolean selected;

    public LeftDrawerModel() {
    }

    public LeftDrawerModel(int icon, String name) {
        this.icon = icon;
        this.name = name;
        this.selected = false;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
