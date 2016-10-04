package com.mlsdev.stafiievskyi.thirtyinchexampleapp.ui;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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
        return new UsersAdapter(this);
    }

    @Override
    protected RecyclerView.LayoutManager provideLayoutManager() {
        return new LinearLayoutManager(this);
    }

    @NonNull
    @Override
    public UsersListDataPresenter providePresenter() {
        return new UsersListDataPresenter();
    }

    @Override
    public void onItemClick(User item) {
        Intent intent = new Intent(this, PostsActivity.class);
        intent.putExtra(PostsActivity.USER_EXTRA_KEY, item);
        startActivity(intent);
    }
}
