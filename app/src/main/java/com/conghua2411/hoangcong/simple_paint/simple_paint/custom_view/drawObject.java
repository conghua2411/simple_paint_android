package com.conghua2411.hoangcong.simple_paint.simple_paint.custom_view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

import java.io.PipedOutputStream;
import java.util.ArrayList;

public class drawObject {
    private ArrayList<PointFloat> list;
    private String type;


    public drawObject() {
        list = new ArrayList<PointFloat>();
        type = "";
    }

    public drawObject( ArrayList<PointFloat> List, String sType) {
        list = List;
        type = sType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void addLast(PointFloat point) {
        list.add(point);
    }

    public PointFloat getPointAtX(int x) {
        if(x > list.size())
            return null;
        return list.get(x);
    }

    private void drawTriangle(Canvas canvas, Paint paint, PointFloat begin, PointFloat end) {

        canvas.drawLine((begin.getX() + end.getX())/2, begin.getY(), begin.getX(), end.getY(), paint);
        canvas.drawLine( begin.getX(), end.getY(), end.getX(), end.getY(), paint);
        canvas.drawLine(end.getX(), end.getY(),(begin.getX() + end.getX())/2, begin.getY(), paint);

    }

    private void drawRectangle(Canvas canvas, Paint paint, PointFloat begin, PointFloat end) {
        //canvas.drawRect(begin.getX(), begin.getY(), end.getX(), end.getY(), paint);

        canvas.drawLine(begin.getX(), begin.getY(), end.getX(), begin.getY(), paint);
        canvas.drawLine(end.getX(), begin.getY(), end.getX(), end.getY(), paint);
        canvas.drawLine(end.getX(), end.getY(), begin.getX(), end.getY(), paint);
        canvas.drawLine(begin.getX(), end.getY(), begin.getX(), begin.getY(), paint);
    }

    private void drawStar(Canvas canvas, Paint paint, PointFloat begin, PointFloat end) {
        PointFloat middle = new PointFloat((begin.getX() + end.getX()) / 2, (begin.getY() + end.getY()) / 2);
        PointFloat pos1 = new PointFloat((begin.getX() + end.getX()) / 2, begin.getY());

        //pos 2 pos 3
        PointFloat pos2 = new PointFloat(end.getX(), (3/8) * (end.getY() - begin.getY()) + begin.getY());

        PointFloat pos3 = new PointFloat((1/6) * (begin.getX() - end.getX()) + end.getX(), end.getY());

        //pos 4 pos 5
        PointFloat pos4 = new PointFloat(begin.getX(), pos2.getY());

        PointFloat pos5 = new PointFloat((5/6) * (begin.getX() - end.getX()) + end.getX(), end.getY());

        canvas.drawLine(pos1.getX(), pos1.getY(), pos2.getX(), pos2.getY(), paint);
        canvas.drawLine(pos2.getX(), pos2.getY(), pos3.getX(), pos3.getY(), paint);
        canvas.drawLine(pos3.getX(), pos3.getY(), pos4.getX(), pos4.getY(), paint);
        canvas.drawLine(pos4.getX(), pos4.getY(), pos5.getX(), pos5.getY(), paint);
        canvas.drawLine(pos5.getX(), pos5.getY(), pos1.getX(), pos1.getY(), paint);
    }

    public void drawObject(Canvas canvas, Paint paint) {
        if(canvas == null || paint == null)
            return;

        if(type != "") {
            if(type.equals("line")) {
                for(int i = 0 ; i < list.size()-1; i++) {
                    canvas.drawLine(list.get(i).getX(),list.get(i).getY(),list.get(i+1).getX(),list.get(i+1).getY(),paint);
                }
            } else if(type == "triangle") {

                if(list.get(0).comparePoint(list.get(list.size()-1)) == 1) {
                    drawTriangle(canvas, paint, list.get(0), list.get(list.size()-1));
                } else if(list.get(0).comparePoint(list.get(list.size()-1)) == 2) {
                    drawTriangle(canvas, paint, new PointFloat( list.get(0).getX(), list.get(list.size() - 1).getY()), new PointFloat(list.get(list.size() - 1).getX(), list.get(0).getY()));
                } else if(list.get(0).comparePoint(list.get(list.size()-1)) == 3) {
                    drawTriangle(canvas, paint, list.get(list.size()-1), list.get(0));
                } else if(list.get(0).comparePoint(list.get(list.size()-1)) == 4) {
                    drawTriangle(canvas, paint, new PointFloat( list.get(list.size() - 1).getX(), list.get(0).getY()), new PointFloat( list.get(0).getX(), list.get(list.size() - 1).getY()));
                }
            } else if(type.equals("rectangle")) {
                if(list.get(0).comparePoint(list.get(list.size()-1)) == 1) {
                    drawRectangle(canvas, paint, list.get(0), list.get(list.size()-1));
                } else if(list.get(0).comparePoint(list.get(list.size()-1)) == 2) {
                    drawRectangle(canvas, paint, new PointFloat( list.get(0).getX(), list.get(list.size() - 1).getY()), new PointFloat(list.get(list.size() - 1).getX(), list.get(0).getY()));
                } else if(list.get(0).comparePoint(list.get(list.size()-1)) == 3) {
                    drawRectangle(canvas, paint, list.get(list.size()-1), list.get(0));
                } else if(list.get(0).comparePoint(list.get(list.size()-1)) == 4) {
                    drawRectangle(canvas, paint, new PointFloat( list.get(list.size() - 1).getX(), list.get(0).getY()), new PointFloat( list.get(0).getX(), list.get(list.size() - 1).getY()));
                }
            }

        }
    }
}
