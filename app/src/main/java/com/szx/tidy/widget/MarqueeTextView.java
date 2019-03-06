package com.szx.tidy.widget;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;

public class MarqueeTextView extends android.support.v7.widget.AppCompatTextView implements Runnable {

    private int currentScrollX;//当前滚动的位置
    private boolean isStop = false;
    private int textWidth;
    private boolean isMeasure = false;

    public MarqueeTextView(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
    }

    public MarqueeTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    public MarqueeTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect)
    {
        if(focused)
        {
            super.onFocusChanged(focused, direction, previouslyFocusedRect);
        }
    }

    public void onWindowFocusChanged(boolean hasWindowFocus)
    {
        if(hasWindowFocus)
        {
            super.onWindowFocusChanged(hasWindowFocus);
        }
    }

    public boolean isFocused()
    {
        return true;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        super.onDraw(canvas);
        if (!isMeasure) {//文字宽度只需要获取一次就可以了
            getTextWidth();
            isMeasure = true;
        }
    }

    /**
     * 获取文字宽度
     */
    private void getTextWidth() {
        Paint paint = this.getPaint();
        String str = this.getText().toString();
        textWidth = (int) paint.measureText(str);
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        currentScrollX -= 2;  // Rolling speed
        scrollTo(currentScrollX, 0);
        if (isStop) {
            return;
        }
        if (getScaleX() <= -(this.getWidth())) {
            scrollTo(textWidth-2, 0);
            currentScrollX = textWidth;
            //return;
        }
        Log.i("STEST","currentScrollX:"+currentScrollX+"   textWidth:"+textWidth);
        post(this);
//        postDelayed(this, 0);
    }

    // start
    public void startScroll() {
        Log.i("STEST","startScroll");
        isStop = false;
        this.removeCallbacks(this);
        post(this);
    }

    // stop
    public void stopScroll() {
        isStop = true;
    }

    // Start from scratch
    public void startFor0() {
        currentScrollX = 0;
        startScroll();
    }
}