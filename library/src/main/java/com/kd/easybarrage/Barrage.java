package com.kd.easybarrage;

public class Barrage {
    private String content;
    private int color;
    private boolean showBorder;

    public Barrage(String content) {
        this(content, R.color.black, false);
    }

    public Barrage(String content, int color) {
        this(content, color, false);
    }

    public Barrage(String content, boolean showBorder) {
        this(content, R.color.black, showBorder);
    }

    public Barrage(String content, int color, boolean showBorder) {
        this.content = content;
        this.color = color;
        this.showBorder = showBorder;
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

}
