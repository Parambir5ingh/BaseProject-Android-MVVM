package com.prm.base_mvvm.ProjectUtils;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by harpreet on 3/21/17.
 */
public abstract class LoadupEndlessRecyclerOnScrollListner extends RecyclerView.OnScrollListener

{
    public static String TAG = LoadupEndlessRecyclerOnScrollListner.class.getSimpleName();

    private int previousTotal = 0; // The total number of items in the dataset after the last load
    private boolean loading = true;
    int lastVisisbleItem = 0;

    private int current_page = 1;

    private LinearLayoutManager mLinearLayoutManagerG;

    public LoadupEndlessRecyclerOnScrollListner(LinearLayoutManager linearLayoutManager) {
        this.mLinearLayoutManagerG = linearLayoutManager;
    }

    public void startOver() {
        current_page = 1;
        previousTotal = 0;
        loading = true;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        lastVisisbleItem = mLinearLayoutManagerG.findFirstCompletelyVisibleItemPosition();

        if (loading) {
            if (lastVisisbleItem > 0) {
                loading = false;
                previousTotal = lastVisisbleItem;
            }
        }

        if (!loading && lastVisisbleItem <= 1) {
            // End has been reached
            // Do something
            current_page++;

            onLoadMore(current_page);

            loading = true;
        }

        onScrollStickyHeaderUpdate();
    }

    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);

        switch (newState) {
            case RecyclerView.SCROLL_STATE_IDLE:
                System.out.println("The RecyclerView is not scrolling");
                onScrollingEnd(current_page);
                break;
            case RecyclerView.SCROLL_STATE_DRAGGING:
                onScrollingStarted(current_page);
                System.out.println("Scrolling now");
                break;
            case RecyclerView.SCROLL_STATE_SETTLING:
                System.out.println("Scroll Settling");
                break;

        }

    }

    public abstract void onLoadMore(int current_page);

    public abstract void onScrollingStarted(int current_page);

    public abstract void onScrollingEnd(int current_page);

    public abstract void onScrollStickyHeaderUpdate();
}