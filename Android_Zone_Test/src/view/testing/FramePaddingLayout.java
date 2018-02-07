package view.testing;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 * MIT License
 * Copyright (c) [2018] [Zone]
 */

public class FramePaddingLayout extends FrameLayout {
    public FramePaddingLayout(@NonNull Context context) {
        super(context);
    }

    public FramePaddingLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        System.out.println("heihei");
    }
}
