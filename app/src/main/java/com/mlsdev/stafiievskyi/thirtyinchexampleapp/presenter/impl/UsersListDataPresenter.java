package com.mlsdev.stafiievskyi.thirtyinchexampleapp.presenter.impl;

import com.mlsdev.stafiievskyi.thirtyinchexampleapp.model.api.FakeApiManager;
import com.mlsdev.stafiievskyi.thirtyinchexampleapp.model.dto.User;
import com.mlsdev.stafiievskyi.thirtyinchexampleapp.presenter.base.BaseListDataPresenter;
import com.mlsdev.stafiievskyi.thirtyinchexampleapp.presenter.view.UsersView;

import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by oleksandr on 03.10.16.
 */

public class UsersListDataPresenter extends BaseListDataPresenter<User, UsersView> {

    @Override
    public Observable<List<User>> provideObservable() {
        return FakeApiManager.getService().getAllUsers().subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
    }

}
