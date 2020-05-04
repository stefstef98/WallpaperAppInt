package com.wallapp.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.GradientDrawable;

import java.util.ArrayList;
import java.util.List;

public class GradientUtils {

    List<String> gradient_list = new ArrayList<>();

    public Bitmap getGradient(int width1, int height1) {

        /*int width = MetricsUtils.getScreenWidth();
        int height = MetricsUtils.getScreenHeight();*/

        Bitmap output = Bitmap.createBitmap(width1, height1, Bitmap.Config.ARGB_8888);

        /*GradientDrawable gradientDrawable = new GradientDrawable();

        gradientDrawable.setColors(new int[]{
                Color.RED,
                Color.GREEN,
                Color.YELLOW,
                Color.CYAN
        });

        gradientDrawable.setGradientType(GradientDrawable.LINEAR_GRADIENT);
        gradientDrawable.setShape(GradientDrawable.RECTANGLE);
        gradientDrawable.setSize(width, height);*/

        LinearGradient gradient =
                new LinearGradient(0, 0, 0, 400,
                        Color.RED, Color.CYAN, Shader.TileMode.CLAMP);

        Paint p = new Paint();
        p.setDither(true);
        p.setShader(gradient);

        Canvas canvas = new Canvas(output);

        canvas.drawRect(new RectF(0, 0, width1, height1), p);

        //canvas.drawBitmap(output, new Matrix(), p);
        //gradientDrawable.draw(canvas);

        return output;
    }
    public void insertGradient(List<String> gradient_list1,String gradient){
        gradient_list1.add(gradient);
    }
}
