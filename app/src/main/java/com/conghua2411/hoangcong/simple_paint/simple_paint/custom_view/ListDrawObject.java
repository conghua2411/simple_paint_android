package com.conghua2411.hoangcong.simple_paint.simple_paint.custom_view;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.ArrayList;

public class ListDrawObject {
    private ArrayList<drawObject> listDraw;
    private ArrayList<drawObject> listUndo;

    public ListDrawObject() {
        listDraw = new ArrayList<>();
        listUndo = new ArrayList<>();
    }

    public int getListDrawSize() {
        return listDraw.size();
    }

    public int getListUndoSize() {
        return listUndo.size();
    }

    public void undo() {
        listUndo.add(listDraw.get(listDraw.size()-1));
        listDraw.remove(listDraw.size() - 1);
    }

    public void redo() {
        listDraw.add(listUndo.get(listUndo.size() - 1));
        listUndo.remove(listUndo.size() - 1);
    }

    public void addObject(drawObject obj) {
        listUndo.clear();
        listDraw.add(obj);
    }

    public void addPointToLast(PointFloat p) {
        if(listDraw.size() == 0)
            return;

        listDraw.get(listDraw.size()-1).addLast(p);
    }

    public void drawListObject(Canvas canvas, Paint paint)
    {
        for(drawObject d : listDraw) {
            d.drawObject(canvas,paint);
        }
    }
}
