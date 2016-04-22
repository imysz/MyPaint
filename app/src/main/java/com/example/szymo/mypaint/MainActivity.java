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

public class MainActivity extends ActionBarActivity {

    PaintView paintView;
    Context ctx;
    int buttonSize;
    Button button_red,button_yellow, button_blue, button_green, button_black;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        paintView = (PaintView) findViewById(R.id.paintView);
        button_red = (Button) findViewById(R.id.button_red);
        button_yellow = (Button) findViewById(R.id.button_yellow);
        button_blue = (Button) findViewById(R.id.button_blue);
        button_green = (Button) findViewById(R.id.button_green);
        button_black = (Button) findViewById(R.id.button_black);
        ctx = getApplicationContext();

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        Log.d("h: ", "" + metrics.heightPixels);
        Log.d("w: ", "" + metrics.widthPixels);
        buttonSize = metrics.widthPixels / 5;
        Log.d("buttonsize: ", "" + metrics.widthPixels / 5);


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



        android.view.ViewGroup.LayoutParams lp = paintView.getLayoutParams();
        lp.height = metrics.heightPixels - buttonSize - 130;
        paintView.setLayoutParams(lp);

        paintView.setBackgroundResource(R.drawable.k2);

        button_red.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                paintView.setColor(Color.RED);
            }
        });

        button_yellow.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                paintView.setColor(Color.YELLOW);
            }
        });

        button_blue.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                paintView.setColor(Color.BLUE);
            }
        });

        button_green.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                paintView.setColor(Color.GREEN);
            }
        });

        button_black.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                paintView.setColor(Color.BLACK);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_kolor, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {


            case R.id.menu_rozmiar:

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();

                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View layout = inflater.inflate(R.layout.size, null);
                AlertDialog.Builder builder = new AlertDialog.Builder(this)
                        .setView(layout);
                alertDialog = builder.create();
                alertDialog.show();
                SeekBar sb = (SeekBar)layout.findViewById(R.id.seekBar);
                sb.setMax(30);
                sb.setProgress(paintView.getSize() - 20);
                sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

                    public void onStartTrackingTouch(SeekBar arg0) {
                        // TODO Auto-generated method stub

                    }

                    public void onStopTrackingTouch(SeekBar arg0) {
                        // TODO Auto-generated method stub

                    }

                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        paintView.setSize(20 + progress);

                    }
                });

                break;

                case R.id.menu_clear:
                  paintView.clear();

                    break;

            case R.id.menu_new:
                paintView.setBackgroundResource(R.drawable.k1);

                break;

        }

        return true;
    }
}
