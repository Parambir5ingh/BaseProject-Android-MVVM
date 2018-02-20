package com.prm.base_mvvm.Base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.view.View;

import com.prm.base_mvvm.Base.Contract.ViewableNoPresenter;
import com.prm.base_mvvm.ProjectUtils.SharedPrefHelper;
import com.prm.base_mvvm.ProjectUtils.BaseUtils;

public abstract class BaseFragmentWithoutPresenter extends Fragment implements ViewableNoPresenter
{

    protected View view;
    protected SharedPrefHelper sharedPrefHelper;



    /**
     * {@inheritDoc}
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getView() == null) {
            onCreateFragmentG();
        }

        setRetainInstance(true);
    }

    @Override
    public SharedPrefHelper getLocalData() {
        if (sharedPrefHelper == null) {
            sharedPrefHelper = new SharedPrefHelper(getActivityG());
        }
        return sharedPrefHelper;
    }

    @Override
    public Context getActivityG() {
        return getActivity();
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void displayError(String message) {
        if (getParentView() != null) {
            BaseUtils.showToast(message,getActivityG(),true);
        }
    }

    public View getParentView() {
        return view;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showLoading(String progressMessage) {
        // no-op by default
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void hideLoading() {
        // no-op by default
    }




    @LayoutRes
    protected abstract int getLayoutId();

    protected abstract void onCreateFragmentG();

}
