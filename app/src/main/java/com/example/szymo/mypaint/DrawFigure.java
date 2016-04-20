package com.example.szymo.mypaint;

/**
 * Created by szymo on 19.04.2016.
 */
import android.graphics.RectF;

public class DrawFigure {

    public int color;
    public int size;
    public RectF figure;

    public DrawFigure(int color, int size, RectF figure) {
        this.color = color;
        this.size=size;
        this.figure = figure;
    }

}
