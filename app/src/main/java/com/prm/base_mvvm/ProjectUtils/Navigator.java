package com.prm.base_mvvm.ProjectUtils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class Navigator
{

    public Navigator()
    {
        // empty
    }

    public void replaceFragment(FragmentActivity activity, int containerViewId, Fragment fragment)
    {
        FragmentManager fragmentManager     = activity.getSupportFragmentManager();
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(containerViewId, fragment);
//        if (fragmentManager.getFragments() != null)
//        {
//            fragmentTransaction.addToBackStack(null);
//        }
        fragmentTransaction.commitAllowingStateLoss();
    }

    public void replaceFragmentWithBackStack(FragmentActivity activity, int containerViewId, Fragment fragment)
    {
        FragmentManager fragmentManager     = activity.getSupportFragmentManager();
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(containerViewId, fragment);
//        if (fragmentManager.getFragments() != null)
//        {
//            fragmentTransaction.addToBackStack(null);
//        }
        fragmentTransaction.commit();
    }
}
