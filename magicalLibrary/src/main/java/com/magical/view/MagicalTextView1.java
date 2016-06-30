package com.magical.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * MagicalTextView
 * Created by ldy on 6/30/16.
 */
public class MagicalTextView1 extends TextView {

    private static final String TAG = MagicalTextView1.class.getSimpleName();

    private static final int DEFAULT_FRAME_WIDTH = 2;

    private Paint paintBg, paintFr;
    private float frameWidth = 0;
    private float fillet = 0;
    private int bgColor, frameColor;

    public MagicalTextView1(Context context) {
        super(context);
        init(null, 0);
    }


    public MagicalTextView1(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }


    public MagicalTextView1(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        TypedArray a = getContext()
                .obtainStyledAttributes(attrs, R.styleable.MagicalTextView, defStyle, 0);
        if (null != a) {
            fillet = a
                    .getDimension(R.styleable.MagicalTextView_fillet, fillet);
            frameWidth = a
                    .getDimension(R.styleable.MagicalTextView_frameWidth, frameWidth);
            bgColor = a
                    .getColor(R.styleable.MagicalTextView_bgColor, bgColor);
            frameColor = a
                    .getColor(R.styleable.MagicalTextView_frameColor, frameColor);
            a.recycle();
        }
        this.setBackgroundColor(Color.TRANSPARENT);
    }


    private void initPaintFr() {
        paintFr = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintFr.setAntiAlias(true);
        paintFr.setStyle(Paint.Style.STROKE);
        paintFr.setColor(frameColor);
        paintFr.setStrokeWidth(frameWidth);
    }


    private void initPaintBg() {
        paintBg = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintBg.setAntiAlias(true);
        paintBg.setStyle(Paint.Style.FILL);
        paintBg.setColor(bgColor);
        paintBg.setStrokeWidth(frameWidth);
    }

    public void setFrameWidth(float frameWidth) {
        this.frameWidth = frameWidth;
        invalidate();
    }

    public void setFillet(float fillet) {
        this.fillet = fillet;
        invalidate();
    }

    public void setBgColor(int bgColor) {
        this.bgColor = bgColor;
        invalidate();
    }

    public void setFrameColor(int frameColor) {
        this.frameColor = frameColor;
        invalidate();
    }

    public void setAllColor(int color) {
        frameColor = color;
        bgColor = color;
        invalidate();
    }

    public void setAllColor(int bgColor, int frameColor) {
        this.frameColor = frameColor;
        this.bgColor = bgColor;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (frameWidth == 0) {
            frameWidth = DEFAULT_FRAME_WIDTH;
        }
        int h = getHeight();
        int w = getWidth();
        RectF rect = new RectF(
                frameWidth / 2,
                frameWidth / 2, w - frameWidth / 2, h - frameWidth / 2);
        if (bgColor != 0) {
            initPaintBg();
            setFillet(canvas, rect, h);
        }
        if (frameColor == 0) {
            frameColor = this.getCurrentTextColor();
        }
        initPaintFr();
        setFillet(canvas, rect, h);
        super.onDraw(canvas);
    }

    private void setFillet(Canvas canvas, RectF rect, int h) {
        if (fillet > 0) {
//            canvas.drawRoundRect(rect, fillet, fillet, paintFr);
            Path path = new Path();
            float[] fillets = new float[]{0, 0, fillet, fillet, 0, 0, fillet, fillet};
            path.addRoundRect(rect, fillets, Path.Direction.CW);
            canvas.drawPath(path, paintFr);
        } else {
            canvas.drawRoundRect(rect, h / 2, h / 2, paintFr);
        }
    }
}
