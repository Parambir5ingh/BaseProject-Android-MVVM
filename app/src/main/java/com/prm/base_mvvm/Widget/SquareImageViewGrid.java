package com.prm.base_mvvm.Widget;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

/**
 * created by PARAMBIR SINGH on 6/9/17.
 */

public class SquareImageViewGrid extends AppCompatImageView
{
    public SquareImageViewGrid(Context context) {
        super(context);
    }

    public SquareImageViewGrid(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SquareImageViewGrid(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }
}
