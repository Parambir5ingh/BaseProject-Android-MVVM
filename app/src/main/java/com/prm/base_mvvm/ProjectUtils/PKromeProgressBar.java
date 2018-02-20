package com.prm.base_mvvm.ProjectUtils;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * created by PARAMBIR SINGH on 22/9/17.
 */

public class PKromeProgressBar extends LinearLayout
{
    private View progressiveView, supportiveView;
    private int progressColor;
    private int maxProgress = 100;

    /**
     * HOW TO USE {@link PKromeProgressBar}
     * Never user height = wrap_content
     * initialize view just like other views
     * See methods documentations to know their use
     */
    public PKromeProgressBar(Context context) {
        super(context);
        initProgressBar();
    }

    public PKromeProgressBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initProgressBar();
    }

    public PKromeProgressBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initProgressBar();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public PKromeProgressBar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initProgressBar();
    }

    /**
     * this method must be called from constructor : USER DONT NEED TO DO ANYTHING WITH THIS
     */
    private void initProgressBar() {
        progressColor = getContext().getResources().getColor(android.R.color.black);

        this.setOrientation(HORIZONTAL);
        progressiveView = new View(getContext());
        LayoutParams params = new LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 10);
        progressiveView.setLayoutParams(params);
        progressiveView.setBackgroundColor(progressColor);

        supportiveView = new View(getContext());
        LayoutParams params2 = new LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1);
        supportiveView.setLayoutParams(params2);

        this.addView(progressiveView);
        this.addView(supportiveView);

        this.setWeightSum(maxProgress);
    }

    /**
     * pass your current progress that need to set on the progressbar
     *
     * @param progress
     */
    public void setProgress(int progress) {
        LayoutParams params = new LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, progress);
        progressiveView.setLayoutParams(params);

        this.setVisibility(progress < maxProgress ? VISIBLE : INVISIBLE);
    }

    /**
     * Pass id of the color that you want to use for progressbar
     *
     * @param color
     */
    public void setProgressColor(int color) {
        progressColor = color;
        progressiveView.invalidate();
    }


    /**
     * Pass the max progress you want to set...
     * By Default it is 100
     *
     * @param maxProgress
     */
    public void setMaxProgress(int maxProgress) {
        this.maxProgress = maxProgress;
        this.invalidate();
        progressiveView.invalidate();
        supportiveView.invalidate();
    }
}
