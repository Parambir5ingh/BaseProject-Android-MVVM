package com.prm.base_mvvm.ProjectUtils;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

public class IsLoadingViewModel extends BaseObservable
{
    private boolean isLoading;

    @Bindable
    public boolean isLoading()
    {
        return isLoading;
    }

    public void setLoading(boolean loading)
    {
        isLoading = loading;
        notifyChange();
    }
}
