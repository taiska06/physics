package com.example.physics.Model;

import java.io.Serializable;

public class BottomNavigationModel implements Serializable {
    private String title;
    private int normalIcon;
    private int clickedIcon;

    public BottomNavigationModel() {
    }

    public BottomNavigationModel(String title,int normalIcon,int clickedIcon) {
        this.title = title;
        this.normalIcon = normalIcon;
        this.clickedIcon=clickedIcon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNormalIcon() {
        return normalIcon;
    }

    public void setNormalIcon(int normalIcon) {
        this.normalIcon = normalIcon;
    }

    public int getClickedIcon() {
        return clickedIcon;
    }

    public void setClickedIcon(int clickedIcon) {
        this.clickedIcon = clickedIcon;
    }
}

