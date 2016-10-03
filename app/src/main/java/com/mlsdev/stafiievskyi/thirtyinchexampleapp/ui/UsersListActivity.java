package com.mlsdev.stafiievskyi.thirtyinchexampleapp.ui;

import android.support.annotation.NonNull;
import android.view.View;

import com.mlsdev.stafiievskyi.thirtyinchexampleapp.R;
import com.mlsdev.stafiievskyi.thirtyinchexampleapp.model.dto.User;
import com.mlsdev.stafiievskyi.thirtyinchexampleapp.presenter.impl.UsersPresenter;
import com.mlsdev.stafiievskyi.thirtyinchexampleapp.presenter.view.UsersView;
import com.mlsdev.stafiievskyi.thirtyinchexampleapp.ui.adapter.BaseAdapter;
import com.mlsdev.stafiievskyi.thirtyinchexampleapp.ui.adapter.UsersAdapter;

import java.util.List;

public class UsersListActivity extends BaseListDataActivity<UsersPresenter, User, UsersView, UsersAdapter.UserViewHolder> implements UsersView {

    @Override
    protected int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected BaseAdapter<User, UsersAdapter.UserViewHolder> provideAdapter() {
        return new UsersAdapter();
    }

    @NonNull
    @Override
    public UsersPresenter providePresenter() {
        return new UsersPresenter();
    }

    @Override
    public void showData(List<User> users) {
        adapter.setData(users);
        tvErrorMessage.setVisibility(View.GONE);
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
}
