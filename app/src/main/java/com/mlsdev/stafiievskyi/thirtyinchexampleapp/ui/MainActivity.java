package com.mlsdev.stafiievskyi.thirtyinchexampleapp.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.mlsdev.stafiievskyi.thirtyinchexampleapp.R;
import com.mlsdev.stafiievskyi.thirtyinchexampleapp.model.dto.User;
import com.mlsdev.stafiievskyi.thirtyinchexampleapp.presenter.UsersPresenter;
import com.mlsdev.stafiievskyi.thirtyinchexampleapp.presenter.UsersView;
import com.mlsdev.stafiievskyi.thirtyinchexampleapp.ui.adapter.BaseAdapter;
import com.mlsdev.stafiievskyi.thirtyinchexampleapp.ui.adapter.UsersAdapter;

import net.grandcentrix.thirtyinch.TiActivity;

import java.util.List;

public class MainActivity extends TiActivity<UsersPresenter, UsersView> implements UsersView {

    private RecyclerView rvData;
    private BaseAdapter<User, UsersAdapter.UserViewHolder> adapter;
    private ProgressBar pbProgress;
    private TextView tvErrorMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        adapter = new UsersAdapter();
        rvData.setAdapter(adapter);

    }

    @NonNull
    @Override
    public UsersPresenter providePresenter() {
        return new UsersPresenter();
    }

    @Override
    public void showUsers(List<User> users) {
        adapter.setData(users);
        tvErrorMessage.setVisibility(View.GONE);
    }

    @Override
    public void showProgress(boolean isShow) {
        pbProgress.setVisibility(isShow ? View.VISIBLE : View.GONE);
    }

    @Override
    public void showError(String errorMessage) {
        tvErrorMessage.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideErrorView() {
        tvErrorMessage.setVisibility(View.GONE);
    }
}
