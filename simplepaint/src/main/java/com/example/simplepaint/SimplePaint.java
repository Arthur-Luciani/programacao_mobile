package com.example.simplepaint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SimplePaint extends BasePaint {

    public SimplePaint(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(x, y);
                saveLayer();
                invalidate();
                return true;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(x, y);
                saveLayer();
                return true;
            case MotionEvent.ACTION_UP:
                break;
        }
        invalidate();
        return super.onTouchEvent(event);
    }

    public void setColor(int color) {
        saveLayer();
        paint.setColor(color);
    }

}
