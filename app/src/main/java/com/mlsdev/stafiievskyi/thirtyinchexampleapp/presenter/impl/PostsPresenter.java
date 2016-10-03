package com.mlsdev.stafiievskyi.thirtyinchexampleapp.presenter.impl;

import com.mlsdev.stafiievskyi.thirtyinchexampleapp.model.api.FakeApiManager;
import com.mlsdev.stafiievskyi.thirtyinchexampleapp.model.dto.Post;
import com.mlsdev.stafiievskyi.thirtyinchexampleapp.presenter.base.BasePresenter;
import com.mlsdev.stafiievskyi.thirtyinchexampleapp.presenter.view.PostsView;

import java.util.List;

import rx.Observable;

/**
 * Created by oleksandr on 03.10.16.
 */

public class PostsPresenter extends BasePresenter<Post, PostsView> {

    private String userId;

    public PostsPresenter(String userId) {
        this.userId = userId;
    }

    @Override
    public Observable<List<Post>> provideObservable() {
        return FakeApiManager.getService().getPostsByUserId(userId);
    }
}
