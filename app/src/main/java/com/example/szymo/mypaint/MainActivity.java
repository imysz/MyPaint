package com.example.szymo.mypaint;

import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioGroup;

public class MainActivity extends ActionBarActivity {

    PaintView paintView;
    Context ctx;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        paintView = (PaintView) findViewById(R.id.paintView);
        ctx = getApplicationContext();
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
            case R.id.menu_kolor:

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
                alertDialogBuilder.setTitle("Wybor koloru");
                final CharSequence[] items = { "Czerwony", "Zielony", "Niebieski","Magneta" };

                alertDialogBuilder.setItems(items, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        switch (item) {
                            case 0:
                                paintView.setColor(Color.RED);
                                break;
                            case 1:
                                paintView.setColor(Color.GREEN);
                                break;
                            case 2:
                                paintView.setColor(Color.BLUE);
                                break;
                        }
                    }
                });



                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();

                break;

                case R.id.menu_clear:
                  paintView.clear();
                   
                    break;

        }

        return true;
    }
}
