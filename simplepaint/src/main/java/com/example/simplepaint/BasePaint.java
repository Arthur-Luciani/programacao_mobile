package com.example.simplepaint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.HashMap;
import java.util.Map;

public class BasePaint extends View {
    protected Path previewPath = new Path();
    protected Paint previewPaint = createPaint(Color.BLACK);
    protected Map<Paint, Path> layers;

    public BasePaint(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        layers = new HashMap<>();
        saveLayer(Color.BLACK);
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        layers.forEach((key, value) -> canvas.drawPath(value, key));
        canvas.drawPath(previewPath, previewPaint);
    }

    private Paint createPaint(int color) {
        Paint p = new Paint();
        p.setColor(color);
        p.setStrokeWidth(10F);
        p.setAntiAlias(true);
        p.setStyle(Paint.Style.STROKE);
        return p;
    }

    protected void saveLayer(int color) {
        previewPath = new Path();
        previewPaint = createPaint(color);
        layers.put(previewPaint, previewPath);
    }
}
