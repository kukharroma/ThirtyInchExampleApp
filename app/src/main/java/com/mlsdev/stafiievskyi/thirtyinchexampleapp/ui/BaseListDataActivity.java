package com.mlsdev.stafiievskyi.thirtyinchexampleapp.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.mlsdev.stafiievskyi.thirtyinchexampleapp.R;
import com.mlsdev.stafiievskyi.thirtyinchexampleapp.presenter.base.BaseListDataPresenter;
import com.mlsdev.stafiievskyi.thirtyinchexampleapp.presenter.base.BaseView;
import com.mlsdev.stafiievskyi.thirtyinchexampleapp.ui.adapter.BaseAdapter;

import net.grandcentrix.thirtyinch.TiActivity;

import java.util.List;

/**
 * Created by oleksandr on 03.10.16.
 */

public abstract class BaseListDataActivity<P extends BaseListDataPresenter<T, V>, T, V extends BaseView<T>,
        H extends RecyclerView.ViewHolder> extends TiActivity<P, V> implements BaseView<T> {

    protected ProgressBar pbProgress;
    protected TextView tvErrorMessage;
    protected RecyclerView rvData;
    protected BaseAdapter<T, H> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutID());
        tvErrorMessage = (TextView) findViewById(R.id.tvError);
        pbProgress = (ProgressBar) findViewById(R.id.pbProgress);
        tvErrorMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPresenter().downloadData();
            }
        });
        rvData = (RecyclerView) findViewById(R.id.rvData);
        rvData.setLayoutManager(new LinearLayoutManager(this));
        adapter = provideAdapter();
        rvData.setAdapter(adapter);

    }

    @Override
    public void showData(List<T> data) {
        adapter.setData(data);
    }

    @Override
    public void showProgress(boolean isShow) {
        pbProgress.setVisibility(isShow ? View.VISIBLE : View.GONE);
    }

    @Override
    public void showErrorView(String errorMessage) {
        tvErrorMessage.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideErrorView() {
        tvErrorMessage.setVisibility(View.GONE);
    }

    protected abstract int getLayoutID();

    protected abstract BaseAdapter<T, H> provideAdapter();
}
