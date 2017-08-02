package com.kd.easybarrage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

public class BorderTextView extends TextView {

    public BorderTextView(Context context, int border_color) {
        this(context, null, border_color);
    }

    public BorderTextView(Context context, AttributeSet attrs, int border_color) {
        super(context, attrs);
        this.border_color = border_color;
    }

    private int border_color;

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(border_color);
        paint.setStrokeWidth(5);
        canvas.drawLine(0, 0, this.getWidth(), 0, paint);
        canvas.drawLine(0, 0, 0, this.getHeight(), paint);
        canvas.drawLine(this.getWidth(), 0, this.getWidth(), this.getHeight(), paint);
        canvas.drawLine(0, this.getHeight(), this.getWidth(), this.getHeight(), paint);
        super.onDraw(canvas);
    }
}