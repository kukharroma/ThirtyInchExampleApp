package com.mlsdev.stafiievskyi.thirtyinchexampleapp.presenter;

import com.mlsdev.stafiievskyi.thirtyinchexampleapp.model.api.FakeApiManager;
import com.mlsdev.stafiievskyi.thirtyinchexampleapp.model.dto.User;

import net.grandcentrix.thirtyinch.TiPresenter;
import net.grandcentrix.thirtyinch.rx.RxTiPresenterSubscriptionHandler;

import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.schedulers.Schedulers;

/**
 * Created by oleksandr on 03.10.16.
 */

public class UsersPresenter extends TiPresenter<UsersView> {

    private RxTiPresenterSubscriptionHandler rxSubscriptionHelper = new RxTiPresenterSubscriptionHandler(this);
    private Observable<List<User>> usersObservable;


    @Override
    protected void onCreate() {
        super.onCreate();
        usersObservable = FakeApiManager.getService().getAllUsers().subscribeOn(Schedulers.newThread());
    }


    public void downloadData() {
        getView().showProgress(true);
        getView().hideErrorView();
        rxSubscriptionHelper.manageSubscription(usersObservable.subscribe(new Observer<List<User>>() {
            @Override
            public void onCompleted() {
                getView().showProgress(false);
                getView().hideErrorView();
            }

            @Override
            public void onError(Throwable e) {
                getView().showProgress(false);
                getView().showError(e.getMessage());
            }

            @Override
            public void onNext(List<User> users) {
                getView().showUsers(users);
            }
        }));
    }

    @Override
    protected void onWakeUp() {
        super.onWakeUp();
        downloadData();
    }
}
