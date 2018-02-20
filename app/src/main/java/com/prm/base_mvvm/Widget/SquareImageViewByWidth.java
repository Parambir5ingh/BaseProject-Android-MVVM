package com.prm.base_mvvm.Widget;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

/**
 * created by PARAMBIR SINGH on 6/9/17.
 */

public class SquareImageViewByWidth extends AppCompatImageView
{
    public SquareImageViewByWidth(Context context) {
        super(context);
    }

    public SquareImageViewByWidth(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SquareImageViewByWidth(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
