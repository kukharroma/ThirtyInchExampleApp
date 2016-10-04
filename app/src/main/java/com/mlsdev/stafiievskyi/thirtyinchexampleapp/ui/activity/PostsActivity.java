package com.mlsdev.stafiievskyi.thirtyinchexampleapp.ui.activity;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mlsdev.stafiievskyi.thirtyinchexampleapp.R;
import com.mlsdev.stafiievskyi.thirtyinchexampleapp.model.dto.Post;
import com.mlsdev.stafiievskyi.thirtyinchexampleapp.model.dto.User;
import com.mlsdev.stafiievskyi.thirtyinchexampleapp.presenter.impl.PostsListDataPresenter;
import com.mlsdev.stafiievskyi.thirtyinchexampleapp.presenter.view.PostsView;
import com.mlsdev.stafiievskyi.thirtyinchexampleapp.ui.adapter.BaseAdapter;
import com.mlsdev.stafiievskyi.thirtyinchexampleapp.ui.adapter.PostsAdapter;

/**
 * Created by oleksandr on 03.10.16.
 */

public class PostsActivity extends BaseListDataActivity<PostsListDataPresenter, Post, PostsView, PostsAdapter.PostViewHolder> {
    public static final String USER_EXTRA_KEY = "user_extra_key";

    private User user;

    @Override
    protected int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected BaseAdapter<Post, PostsAdapter.PostViewHolder> provideAdapter() {
        return new PostsAdapter();
    }

    @Override
    protected RecyclerView.LayoutManager provideLayoutManager() {
        return new LinearLayoutManager(this);
    }


    @NonNull
    @Override
    public PostsListDataPresenter providePresenter() {
        if (user == null)
            user = (User) getIntent().getSerializableExtra(USER_EXTRA_KEY);
        return new PostsListDataPresenter(String.valueOf(user.getId()));
    }

    @Override
    public void onItemClick(Post item) {

    }
}
