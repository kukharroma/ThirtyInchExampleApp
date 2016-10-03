package com.mlsdev.stafiievskyi.thirtyinchexampleapp.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.mlsdev.stafiievskyi.thirtyinchexampleapp.R;
import com.mlsdev.stafiievskyi.thirtyinchexampleapp.model.dto.Post;
import com.mlsdev.stafiievskyi.thirtyinchexampleapp.model.dto.User;
import com.mlsdev.stafiievskyi.thirtyinchexampleapp.presenter.impl.PostsListDataPresenter;
import com.mlsdev.stafiievskyi.thirtyinchexampleapp.presenter.view.PostsView;
import com.mlsdev.stafiievskyi.thirtyinchexampleapp.ui.adapter.BaseAdapter;
import com.mlsdev.stafiievskyi.thirtyinchexampleapp.ui.adapter.PostsAdapter;

import java.util.List;

/**
 * Created by oleksandr on 03.10.16.
 */

public class PostsActivity extends BaseListDataActivity<PostsListDataPresenter, Post, PostsView, PostsAdapter.PostViewHolder> implements PostsView {
    public static final String USER_EXTRA_KEY = "user_extra_key";

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected BaseAdapter<Post, PostsAdapter.PostViewHolder> provideAdapter() {
        return new PostsAdapter();
    }


    @NonNull
    @Override
    public PostsListDataPresenter providePresenter() {
        if (user == null)
            user = (User) getIntent().getSerializableExtra(USER_EXTRA_KEY);
        return new PostsListDataPresenter(String.valueOf(user.getId()));
    }

    @Override
    public void showData(List<Post> data) {

    }
}
