package com.godlike.retrofit.bean;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class MoveView extends View {
    private int lastX;
    private int lastY;

    public MoveView(Context context) {
        super(context);
        initView();
    }

    public MoveView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public MoveView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        setBackgroundColor(Color.BLUE);
    }

    // 绝对坐标方式
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int rawX = (int) (event.getRawX());
        int rawY = (int) (event.getRawY());
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // 记录触摸点坐标
                lastX = rawX;
                lastY = rawY;
                break;
            case MotionEvent.ACTION_MOVE:
                // 计算偏移量
                int offsetX = rawX - lastX;
                int offsetY = rawY - lastY;
                // 在当前left、top、right、bottom的基础上加上偏移量
                layout(getLeft() + offsetX,
                        getTop() + offsetY,
                        getRight() + offsetX,
                        getBottom() + offsetY);
                // 重新设置初始坐标
                lastX = rawX;
                lastY = rawY;
                break;
        }
        return true;
    }
}
