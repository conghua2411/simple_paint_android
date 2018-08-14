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
import android.widget.TextView;

import com.conghua2411.hoangcong.simple_paint.simple_paint.R;

public class dialog_color_picker extends Dialog implements View.OnClickListener {

    private View v;
    private SeekBar seekBarRed, seekBarGreen, seekBarBlue;
    private Button btnOk, btnCancel;
    private TextView tvRedInt, tvGreenInt, tvBlueInt;

    private Integer intRed, intGreen, intBlue;

    public interface OnOkEventListener {
        public void okClick(int red, int green, int blue);
    }

    private OnOkEventListener onOkEventListener;

    public dialog_color_picker(@NonNull Context context) {
        super(context);
    }

    public dialog_color_picker(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    public dialog_color_picker(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    public dialog_color_picker(Context context, OnOkEventListener onOkEventListener) {
        super(context);

        this.onOkEventListener = onOkEventListener;
    }

    public void setOnOkEventListener(OnOkEventListener listener) {
        onOkEventListener = listener;
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

        intRed = seekBarRed.getProgress();
        intGreen = seekBarGreen.getProgress();
        intBlue = seekBarBlue.getProgress();

        tvRedInt = findViewById(R.id.tv_red_int);
        tvGreenInt = findViewById(R.id.tv_green_int);
        tvBlueInt = findViewById(R.id.tv_blue_int);



        v = findViewById(R.id.view_color);
        changeViewColor();

        changeTvColorInt();

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onOkEventListener.okClick(intRed,intGreen,intBlue);
                dismiss();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        seekBarRed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                intRed = i;
                changeViewColor();
                changeTvColorInt();
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
                changeTvColorInt();
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
                changeTvColorInt();
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

    private void changeTvColorInt() {
        tvRedInt.setText(String.valueOf(intRed));
        tvGreenInt.setText(String.valueOf(intGreen));
        tvBlueInt.setText(String.valueOf(intBlue));
    }



    @Override
    public void onClick(View view) {

    }
}
