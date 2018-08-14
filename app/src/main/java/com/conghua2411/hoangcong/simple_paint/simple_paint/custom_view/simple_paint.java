package com.conghua2411.hoangcong.simple_paint.simple_paint.custom_view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class simple_paint extends View {
    private drawObject drawObj;
    private ListDrawObject list;
    private Paint mPaint;
    private String mType;

    private Integer mPaintColor;

    public simple_paint(Context context) {
        super(context);
        init();
    }

    public simple_paint(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public simple_paint(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

//    public simple_paint(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
//        super(context, attrs, defStyleAttr, defStyleRes);
//    }

    void init()
    {
        drawObj = new drawObject();
        mType = "line";
        drawObj.setType(mType);
        list = new ListDrawObject();
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.RED);
        mPaintColor = Color.RED;
        mPaint.setStrokeWidth(8);
    }

    public void changeType(String type) {
        mType = type;
    }

    public void undo() {
        if(list.getListDrawSize() > 0) {
            list.undo();
            postInvalidate();
        }
    }

    public void redo() {
        if(list.getListUndoSize() > 0) {
            list.redo();
            postInvalidate();
        }
    }

    public void clear() {
        list.clear();
        postInvalidate();
    }

    public void changePaintColor(int red, int green, int blue) {
        mPaintColor = Color.rgb(red,green,blue);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.WHITE);

        list.drawListObject(canvas, mPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {

                drawObj = new drawObject();
                drawObj.setType(mType);
                drawObj.setColor(mPaintColor);
                drawObj.addLast(new PointFloat(event.getX(), event.getY()));

                list.addObject(drawObj);

                postInvalidate();

                return true;
            }
            case MotionEvent.ACTION_MOVE: {

                list.addPointToLast(new PointFloat(event.getX(), event.getY()));

                postInvalidate();

                return true;
            }
            case MotionEvent.ACTION_UP: {

                return true;
            }
        }

        return super.onTouchEvent(event);
    }
}
