package com.conghua2411.hoangcong.simple_paint.simple_paint.custom_dialog_color;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.SeekBar;

import com.conghua2411.hoangcong.simple_paint.simple_paint.R;

public class dialog_color_picker extends Dialog implements View.OnClickListener {

    private View v;
    private SeekBar seekBarRed, seekBarGreen, seekBarBlue;
    private Button btnOk, btnCancel;

    private Integer intRed, intGreen, intBlue;

    public dialog_color_picker(@NonNull Context context) {
        super(context);
    }

    public dialog_color_picker(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    public dialog_color_picker(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_color_picker);
        btnOk = findViewById(R.id.btn_OK);
        btnCancel = findViewById(R.id.btn_cancel);

        seekBarRed = findViewById(R.id.seekbar_red);
        seekBarGreen = findViewById(R.id.seekbar_green);
        seekBarBlue = findViewById(R.id.seekbar_blue);

        intRed = 0;
        intGreen = 0;
        intBlue = 0;

        v = findViewById(R.id.view_color);
        changeViewColor();

        seekBarRed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                intRed = i;
                changeViewColor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBarGreen.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                intGreen = i;
                changeViewColor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBarBlue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                intBlue = i;
                changeViewColor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    private void changeViewColor()
    {
        v.setBackgroundColor(Color.rgb(intRed,intGreen,intBlue));
    }

    @Override
    public void onClick(View view) {

    }
}
