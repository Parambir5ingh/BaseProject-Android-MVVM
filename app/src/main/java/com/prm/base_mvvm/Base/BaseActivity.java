package com.prm.base_mvvm.Base;

import android.app.ProgressDialog;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.prm.base_mvvm.Base.Contract.Presentable;
import com.prm.base_mvvm.Base.Contract.Viewable;
import com.prm.base_mvvm.ProjectUtils.SharedPrefHelper;
import com.prm.base_mvvm.R;

/**
 * @param <B> Data Binder for the activity.
 * @param <T> presenter class for the activity.
 */

public abstract class BaseActivity<B extends ViewDataBinding, T extends Presentable> extends AppCompatActivity implements Viewable<T>
{
    protected T presenter;
    protected B binding;

    private ProgressDialog progressDialog;
    private String progressMessage = "Please wait";
    private String progressTitle = "";

    /**
     * {@inheritDoc}
     */
    @Override
    public void onStart() {
        super.onStart();
        getPresenter().onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        getPresenter().onResume();
    }

    @Override
    protected void onPause() {
        getPresenter().onPause();
        super.onPause();
    }

    public void setupToolbar(String title) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView viewById = (TextView) toolbar.findViewById(R.id.title);
        if (viewById == null) {
            viewById = (TextView) toolbar.findViewById(R.id.title);
        }

        if (viewById != null) {
            viewById.setText(title);
            getSupportActionBar().setTitle("");
        }
        else {
            getSupportActionBar().setTitle(title);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(setLayoutId());
        binding = DataBindingUtil.setContentView(this, setLayoutId());

        onCreateActivityG();
        getPresenter().onViewCreated();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onStop() {
        getPresenter().onStop();
        super.onStop();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDestroy() {
        getPresenter().detachView();
        presenter = null;
        super.onDestroy();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void displayError(String message) {
        if (setParentView() != null) {
            Snackbar.make(setParentView(), message, Snackbar.LENGTH_LONG).show();
        }
    }

    public void setProgressMessage(String progressMessage) {
        this.progressMessage = progressMessage;
    }

    public void setProgressTitle(String progressTitle) {
        this.progressTitle = progressTitle;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showLoading(String progressMessage) {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(getActivityG());
            progressDialog.setTitle(progressTitle);
            progressDialog.setMessage(progressMessage);
        }
        progressDialog.show();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void hideLoading() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T getPresenter() {
        return presenter;
    }

    /**
     * @return {@link DataBindingUtil} Data Binder for current activity.
     */
    public B getDataBinder() {
        return binding;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void injectPresenter(T presenter) {
        this.presenter = presenter;
    }

    SharedPrefHelper sharedPrefHelper;

    @Override
    public SharedPrefHelper getLocalData() {
        if (sharedPrefHelper == null) {
            sharedPrefHelper = new SharedPrefHelper(getApplicationContext());
        }
        return sharedPrefHelper;
    }

    /**
     * @return Layout res file.
     */
    protected abstract int setLayoutId();

    /**
     * @return parent view for current screen.(<i>can be used to show {@link Snackbar})
     */
    protected View setParentView() {
        return findViewById(android.R.id.content);
    }

    /**
     * injectPresenter(Class extends {@link BasePresenter});
     * after this attach a {@link Viewable} interface to the presenter.
     * using {@link BasePresenter#attachView(Viewable)}; method.
     */
    protected abstract void onCreateActivityG();
}
