package com.kd.easybarrage;

import android.graphics.Color;

public class Barrage {

    private String content;
    private int color;
    private boolean showBorder;
    private int backGroundColor;

    public Barrage(String content) {
        this(content, R.color.black, false, Color.WHITE);
    }

    public Barrage(String content, int color) {
        this(content, color, false, Color.WHITE);
    }

    public Barrage(String content, boolean showBorder) {
        this(content, R.color.black, showBorder, Color.WHITE);
    }

    public Barrage(String content, int color, int backGroundColor) {
        this(content, color, false, backGroundColor);
    }

    private Barrage(String content, int color, boolean showBorder, int backGroundColor) {
        this.content = content;
        this.color = color;
        this.showBorder = showBorder;
        this.backGroundColor = backGroundColor;
    }

    public boolean isShowBorder() {
        return showBorder;
    }

    public void setShowBorder(boolean showBorder) {
        this.showBorder = showBorder;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getBackGroundColor() {
        return backGroundColor;
    }

    public void setBackGroundColor(int backGroundColor) {
        this.backGroundColor = backGroundColor;
    }
}
