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

    protected Path actualPath;
    protected Paint actualPaint;
    private Path previewPath = new Path();
    private Paint previewPaint;
    protected Map<Paint, Path> layers;

    ArrayAdapter<String> adapter;

    public BasePaint(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        savePath();
        savePaint();
        layers = new HashMap<>();
        saveLayer();
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        layers.forEach((key, value) -> canvas.drawPath(value, key));
        canvas.drawPath(previewPath, previewPaint);
    }

    protected void savePaint() {
        actualPaint = createPaint();
        previewPaint = actualPaint;
    }

    private Paint createPaint() {
        Paint p = new Paint();
        p.setColor(Color.BLACK);
        p.setStrokeWidth(10F);
        p.setAntiAlias(true);
        p.setStyle(Paint.Style.STROKE);
        return p;
    }

    protected void savePath() {
        actualPath = new Path();
        previewPath = actualPath;
    }

    protected void saveLayer() {
        savePaint();
        layers.put(previewPaint, previewPath);
    }
}
