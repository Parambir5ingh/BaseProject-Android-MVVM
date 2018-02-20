/*
 * Copyright (c) 2017. Code by PRM , Everyone is open to use code in this project. Happy coding
 */

package com.prm.base_mvvm.Widget;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;

/**
 * View with height==width i.e Square
 */
public class SquareCardView extends CardView
{

    public SquareCardView(Context context)
    {
        super(context);
    }

    public SquareCardView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public SquareCardView(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }

}
