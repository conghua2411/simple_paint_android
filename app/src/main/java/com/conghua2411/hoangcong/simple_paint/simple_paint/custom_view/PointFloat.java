package com.conghua2411.hoangcong.simple_paint.simple_paint.custom_view;

public class PointFloat {
    private float x,y;

    public PointFloat() {
        x = -1;
        y = -1;
    }

    public PointFloat(float fx, float fy) {
        x = fx;
        y = fy;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setX(float fx) {
        x = fx;
    }

    public void setY(float fy) {
        y = fy;
    }

    public int comparePoint(PointFloat p) {
        if(x < p.getX() && y < p.getY())
            return 1;
        if(x < p.getX() && y > p.getY())
            return 2;
        if(x > p.getX() && y > p.getY())
            return 3;
        if(x > p.getX() && y < p.getY())
            return 4;
        return 0;
    }
}
