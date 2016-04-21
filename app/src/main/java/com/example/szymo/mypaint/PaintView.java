package com.example.szymo.mypaint;

/**
 * Created by szymo on 19.04.2016.
 */
import java.io.File;
import java.util.ArrayList;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;

public class PaintView extends SurfaceView implements SurfaceHolder.Callback {

    ArrayList<DrawFigure> punkty;
    Paint paint = new Paint();
    private int color;
    private int size;

    public PaintView(Context context, AttributeSet attrs) {
        super(context, attrs);
        punkty = new ArrayList<DrawFigure>();
        paint = new Paint();
        color = Color.RED;
        size=20;

        DisplayMetrics metrics = new DisplayMetrics();
    }

    public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
        // TODO Auto-generated method stub
    }

    public void surfaceCreated(SurfaceHolder arg0) {

    }

    public void surfaceDestroyed(SurfaceHolder arg0) {
        // TODO Auto-generated method stub
    }

    public boolean onTouchEvent(MotionEvent event) {

        RectF oval = new RectF(event.getX() - size, event.getY() - size, event.getX() + size, event.getY() + size);
        punkty.add(new DrawFigure(color,size,oval));
        invalidate();
        return true;
    }

    protected void onDraw(Canvas canvas) {

        for (DrawFigure punkt : punkty) {
            paint.setColor(punkt.color);
            canvas.drawOval(punkt.figure, paint);
        }


    }

    public void setColor(int newColor) {
       color = newColor;
    }

    public void clear(){
        punkty = new ArrayList<DrawFigure>();
        invalidate();
    }

    public int getSize(){
        return size;
    }

    public void setSize(int size){
        this.size=size;
    }

}