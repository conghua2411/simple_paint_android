package com.conghua2411.hoangcong.simple_paint.simple_paint;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.conghua2411.hoangcong.simple_paint.simple_paint.custom_view.simple_paint;

public class MainActivity extends AppCompatActivity {

    private Button btnLine;
    private Button btnTriangle;
    private Button btnRectangle;
    private simple_paint simplePaint;
    private Button btnUndo;
    private Button btnRedo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        btnLine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                simplePaint.changeType("line");
                setBtnEnable(false,true,true);
            }
        });

        btnRectangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                simplePaint.changeType("rectangle");
                setBtnEnable(true,true,false);
            }
        });

        btnTriangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                simplePaint.changeType("triangle");
                setBtnEnable(true,false,true);
            }
        });

        btnUndo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                simplePaint.undo();
            }
        });

        btnRedo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                simplePaint.redo();
            }
        });

    }

    private void init() {
        btnLine = findViewById(R.id.btn_line);
        btnRectangle = findViewById(R.id.btn_rectangle);
        btnTriangle = findViewById(R.id.btn_triangle);
        simplePaint = findViewById(R.id.simple_paint);

        btnUndo = findViewById(R.id.btn_undo);
        btnRedo = findViewById(R.id.btn_redo);

        setBtnEnable(false,true,true);
    }

    private void setBtnEnable(boolean Line, boolean Triangle, boolean Rectangle) {
        btnLine.setEnabled(Line);
        btnTriangle.setEnabled(Triangle);
        btnRectangle.setEnabled(Rectangle);
    }
}
