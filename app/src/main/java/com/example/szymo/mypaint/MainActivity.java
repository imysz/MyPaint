package com.example.szymo.mypaint;

import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.SeekBar;


import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

public class MainActivity extends ActionBarActivity {

    Button button_red, button_yellow, button_blue, button_green, button_black,button_brown,button_status;
    int buttonSize;
    DrawingView drawView;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getApplication();
        setContentView(R.layout.activity_main);
        // paintView = (PaintView) findViewById(R.id.paintView);
        drawView = (DrawingView)findViewById(R.id.paintview);


        button_red = (Button) findViewById(R.id.button_red);
        button_yellow = (Button) findViewById(R.id.button_yellow);
        button_blue = (Button) findViewById(R.id.button_blue);
        button_green = (Button) findViewById(R.id.button_green);
        button_black = (Button) findViewById(R.id.button_black);
        button_brown = (Button) findViewById(R.id.button_brown);
        button_status = (Button) findViewById(R.id.button_status);


        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        Log.d("h: ", "" + metrics.heightPixels);
        Log.d("w: ", "" + metrics.widthPixels);
        buttonSize = metrics.widthPixels / 6;
        Log.d("buttonsize: ", "" + metrics.widthPixels / 6);


        LinearLayout.LayoutParams params_black = (LinearLayout.LayoutParams) button_black.getLayoutParams();
        params_black.width = buttonSize;
        params_black.height = buttonSize;
        button_black.setLayoutParams(params_black);

        LinearLayout.LayoutParams params_red = (LinearLayout.LayoutParams) button_red.getLayoutParams();
        params_red.width = buttonSize;
        params_red.height = buttonSize;
        button_red.setLayoutParams(params_red);

        LinearLayout.LayoutParams params_yellow = (LinearLayout.LayoutParams) button_yellow.getLayoutParams();
        params_yellow.width = buttonSize;
        params_yellow.height = buttonSize;
        button_yellow.setLayoutParams(params_yellow);

        LinearLayout.LayoutParams params_green = (LinearLayout.LayoutParams) button_green.getLayoutParams();
        params_green.width = buttonSize;
        params_green.height = buttonSize;
        button_green.setLayoutParams(params_green);

        LinearLayout.LayoutParams params_blue = (LinearLayout.LayoutParams) button_blue.getLayoutParams();
        params_blue.width = buttonSize;
        params_blue.height = buttonSize;
        button_blue.setLayoutParams(params_blue);

        LinearLayout.LayoutParams params_brown = (LinearLayout.LayoutParams) button_brown.getLayoutParams();
        params_brown.width = buttonSize;
        params_brown.height = buttonSize;
        button_brown.setLayoutParams(params_blue);

        drawView.setBackgroundResource(R.drawable.k2);


        button_red.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                drawView.setColor("#FF0000");
                button_status.setBackgroundResource(R.drawable.oval_background_red);
            }
        });

        button_yellow.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                drawView.setColor("#FFFF00");
                button_status.setBackgroundResource(R.drawable.oval_background_yellow);
            }
        });

        button_blue.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                drawView.setColor("#0000FF");
                button_status.setBackgroundResource(R.drawable.oval_background_blue);
            }
        });

        button_green.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                drawView.setColor("#00FF00");
                button_status.setBackgroundResource(R.drawable.oval_background_green);
            }
        });

        button_black.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                drawView.setColor("#000000");
                button_status.setBackgroundResource(R.drawable.oval_background_black);
            }
        });

        button_brown.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                drawView.setColor("#835C3B");
                button_status.setBackgroundResource(R.drawable.oval_background_brown);
            }
        });

    }


}


