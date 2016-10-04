package com.mlsdev.stafiievskyi.thirtyinchexampleapp.presenter.impl;

import com.mlsdev.stafiievskyi.thirtyinchexampleapp.model.api.FakeApiManager;
import com.mlsdev.stafiievskyi.thirtyinchexampleapp.model.dto.Post;
import com.mlsdev.stafiievskyi.thirtyinchexampleapp.presenter.base.BaseListDataPresenter;
import com.mlsdev.stafiievskyi.thirtyinchexampleapp.presenter.view.PostsView;

import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by oleksandr on 03.10.16.
 */

public class PostsListDataPresenter extends BaseListDataPresenter<Post, PostsView> {

    private String userId;

    public PostsListDataPresenter(String userId) {
        this.userId = userId;
    }

    @Override
    public Observable<List<Post>> provideObservable() {
        return FakeApiManager.getService().getPostsByUserId(userId).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
    }
}
