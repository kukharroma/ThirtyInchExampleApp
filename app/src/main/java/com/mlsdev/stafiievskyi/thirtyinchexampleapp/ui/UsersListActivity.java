package com.mlsdev.stafiievskyi.thirtyinchexampleapp.ui;

import android.support.annotation.NonNull;

import com.mlsdev.stafiievskyi.thirtyinchexampleapp.R;
import com.mlsdev.stafiievskyi.thirtyinchexampleapp.model.dto.User;
import com.mlsdev.stafiievskyi.thirtyinchexampleapp.presenter.impl.UsersListDataPresenter;
import com.mlsdev.stafiievskyi.thirtyinchexampleapp.presenter.view.UsersView;
import com.mlsdev.stafiievskyi.thirtyinchexampleapp.ui.adapter.BaseAdapter;
import com.mlsdev.stafiievskyi.thirtyinchexampleapp.ui.adapter.UsersAdapter;

public class UsersListActivity extends BaseListDataActivity<UsersListDataPresenter, User, UsersView, UsersAdapter.UserViewHolder> {

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
    public UsersListDataPresenter providePresenter() {
        return new UsersListDataPresenter();
    }
}
