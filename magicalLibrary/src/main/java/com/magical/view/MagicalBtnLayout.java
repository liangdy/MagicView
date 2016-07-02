package com.magical.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MagicalBtnLayout extends LinearLayout {

    private static final int DEFAULT_NORMAL_COLOR = R.color.default_normal_color;
    private static final int DEFAULT_PRESSED_COLOR = R.color.default_pressed_color;

    private float rounded = 0;
    private boolean isPress;
    private OnClickListener listener;
    private int defaultColor, pressedColor;
    private Paint mPaint;
    private float leftTopRounded = 0;
    private float leftBottomRounded = 0;
    private float rightTopRounded = 0;
    private float rightBottomRounded = 0;


    public MagicalBtnLayout(Context context) {
        super(context);
        init(null, 0);
    }


    public MagicalBtnLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }


    public MagicalBtnLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }


    private void init(AttributeSet attrs, int defStyle) {
        TypedArray a = getContext()
                .obtainStyledAttributes(attrs, R.styleable.MagicalBtnView, defStyle, 0);
        rounded = a.getDimension(R.styleable.MagicalBtnView_rounded, rounded);
        leftTopRounded = a.getDimension(R.styleable.MagicalBtnView_leftTopRounded, leftTopRounded);
        leftBottomRounded = a.getDimension(R.styleable.MagicalBtnView_leftBottomRounded, leftBottomRounded);
        rightTopRounded = a.getDimension(R.styleable.MagicalBtnView_rightTopRounded, rightTopRounded);
        rightBottomRounded = a.getDimension(R.styleable.MagicalBtnView_rightBottomRounded, rightBottomRounded);
        defaultColor = a
                .getColor(R.styleable.MagicalBtnView_defaultColor, getResources()
                        .getColor(DEFAULT_NORMAL_COLOR));
        pressedColor = a
                .getColor(R.styleable.MagicalBtnView_pressedColor, getResources()
                        .getColor(DEFAULT_PRESSED_COLOR));
        a.recycle();
        this.setBackgroundColor(Color.TRANSPARENT);
    }


    public void setBgColor(int dColor, int pColor) {
        this.defaultColor = dColor;
        this.pressedColor = pColor;
        this.invalidate();
    }


    public void setRounded(float f) {
        this.rounded = f;
    }


    @Override
    public void setOnClickListener(OnClickListener listener) {
        this.listener = listener;
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (null != listener) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    isPress = true;
                    this.invalidate();
                    break;
                case MotionEvent.ACTION_UP:
                case MotionEvent.ACTION_CANCEL:
                case MotionEvent.ACTION_OUTSIDE:
                    isPress = false;
                    this.invalidate();
                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        if (listener != null) {
                            listener.onClick(this);
                        }
                    }
                    break;
                default:
                    break;
            }
            return true;
        } else {
            return super.onTouchEvent(event);
        }
    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        initPaint();
        if (isPress) {
            mPaint.setColor(pressedColor);
        } else {
            mPaint.setColor(defaultColor);
        }
        RectF mRectF = new RectF(0, 0, getWidth(), getHeight());
        setrounded(canvas, mRectF, getHeight());
        super.onDraw(canvas);
    }

    private void setrounded(Canvas canvas, RectF rect, int h) {
        if (rounded > 0) {
            canvas.drawRoundRect(rect, rounded, rounded, mPaint);
        } else {
            if (leftTopRounded <= 0 && leftBottomRounded <= 0 && rightTopRounded <= 0 && rightBottomRounded <= 0) {
                canvas.drawRoundRect(rect, h / 2, h / 2, mPaint);
            } else {
                Path path = new Path();
                float[] roundeds = new float[]{leftTopRounded, leftTopRounded, rightTopRounded, rightTopRounded, rightBottomRounded, rightBottomRounded, leftBottomRounded, leftBottomRounded};
                path.addRoundRect(rect, roundeds, Path.Direction.CW);
                canvas.drawPath(path, mPaint);
            }
        }
    }
}
