package com.example.simplepaint;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ArrayAdapter;

import androidx.annotation.Nullable;

public class SimplePaint extends BasePaint {

    public SimplePaint(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        System.out.println(event.getAction());
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                previewPath.moveTo(x, y);
                invalidate();
                return true;
            case MotionEvent.ACTION_MOVE:
                previewPath.lineTo(x, y);
                invalidate();
                return true;
            case MotionEvent.ACTION_UP:
                saveLayer(previewPaint.getColor());
                invalidate();
                break;
        }
        invalidate();
        return super.onTouchEvent(event);
    }

    public void setColor(int color) {
        saveLayer(previewPaint.getColor());
        previewPaint.setColor(color);
    }

}
