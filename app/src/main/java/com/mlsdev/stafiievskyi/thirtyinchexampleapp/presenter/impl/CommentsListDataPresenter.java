package com.mlsdev.stafiievskyi.thirtyinchexampleapp.presenter.impl;

import com.mlsdev.stafiievskyi.thirtyinchexampleapp.model.api.FakeApiManager;
import com.mlsdev.stafiievskyi.thirtyinchexampleapp.model.dto.Comment;
import com.mlsdev.stafiievskyi.thirtyinchexampleapp.presenter.base.BaseListDataPresenter;
import com.mlsdev.stafiievskyi.thirtyinchexampleapp.presenter.view.CommentsView;

import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by oleksandr on 04.10.16.
 */

public class CommentsListDataPresenter extends BaseListDataPresenter<Comment, CommentsView> {

    public CommentsListDataPresenter(String postId) {
        this.postId = postId;
    }

    private String postId;

    @Override
    public Observable<List<Comment>> provideObservable() {
        return FakeApiManager.getService().getCommentByPostId(postId).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
    }
}
