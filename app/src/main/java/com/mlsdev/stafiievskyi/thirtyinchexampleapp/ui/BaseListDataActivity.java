package com.mlsdev.stafiievskyi.thirtyinchexampleapp.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.mlsdev.stafiievskyi.thirtyinchexampleapp.R;
import com.mlsdev.stafiievskyi.thirtyinchexampleapp.presenter.base.BasePresenter;
import com.mlsdev.stafiievskyi.thirtyinchexampleapp.presenter.base.BaseView;
import com.mlsdev.stafiievskyi.thirtyinchexampleapp.ui.adapter.BaseAdapter;

import net.grandcentrix.thirtyinch.TiActivity;

/**
 * Created by oleksandr on 03.10.16.
 */

public abstract class BaseListDataActivity<P extends BasePresenter<T, V>, T, V extends BaseView<T>,
        H extends RecyclerView.ViewHolder> extends TiActivity<P, V> {

    protected ProgressBar pbProgress;
    protected TextView tvErrorMessage;
    protected RecyclerView rvData;
    protected BaseAdapter adapter;


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

    protected abstract int getLayoutID();

    protected abstract BaseAdapter<T, H> provideAdapter();
}
