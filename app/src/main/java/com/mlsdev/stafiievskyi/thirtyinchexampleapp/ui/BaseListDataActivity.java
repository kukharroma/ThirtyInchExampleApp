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
import com.mlsdev.stafiievskyi.thirtyinchexampleapp.ui.adapter.OnAdapterItemClickListener;

import net.grandcentrix.thirtyinch.TiActivity;

import java.util.List;

/**
 * Created by oleksandr on 03.10.16.
 */

public abstract class BaseListDataActivity<P extends BaseListDataPresenter<T, V>, T, V extends BaseView<T>,
        H extends RecyclerView.ViewHolder> extends TiActivity<P, V> implements BaseView<T>, OnAdapterItemClickListener<T> {

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
        rvData = (RecyclerView) findViewById(R.id.rvData);
        if (pbProgress == null) {
            throw new NullPointerException(
                    "Loading view is null! Have you specified a loading view in your layout xml file?"
                            + " You have to give your loading View the id R.id.pbProgress");
        }

        if (rvData == null) {
            throw new NullPointerException(
                    "Content view is null! Have you specified a content view in your layout xml file?"
                            + " You have to give your content View the id R.id.rvData");
        }

        if (tvErrorMessage == null) {
            throw new NullPointerException(
                    "Error view is null! Have you specified a content view in your layout xml file?"
                            + " You have to give your error View the id R.id.tvError");
        }
        tvErrorMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPresenter().downloadData();
            }
        });
        rvData.setLayoutManager(provideLayoutManager());
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

    protected abstract RecyclerView.LayoutManager provideLayoutManager();
}
