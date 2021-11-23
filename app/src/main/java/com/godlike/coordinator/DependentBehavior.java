package com.godlike.coordinator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import com.godlike.retrofit.bean.MoveView;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;

public class DependentBehavior extends CoordinatorLayout.Behavior<View> {

    public DependentBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(@NonNull CoordinatorLayout parent, @NonNull View child, View dependency) {
        // 观察自定义的 MoveView 的移动
        return dependency instanceof MoveView;
    }

    @Override
    public boolean onDependentViewChanged(@NonNull CoordinatorLayout parent, @NonNull View child, @NonNull View dependency) {
        int offset = dependency.getTop() - child.getTop();
        ViewCompat.offsetTopAndBottom(child, offset);
        return true;
    }
}

