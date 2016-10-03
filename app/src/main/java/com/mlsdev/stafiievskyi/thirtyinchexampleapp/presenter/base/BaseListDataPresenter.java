package com.mlsdev.stafiievskyi.thirtyinchexampleapp.presenter.base;

import android.util.Log;

import net.grandcentrix.thirtyinch.TiPresenter;
import net.grandcentrix.thirtyinch.rx.RxTiPresenterSubscriptionHandler;

import java.util.List;

import rx.Observable;
import rx.Observer;

/**
 * Created by oleksandr on 03.10.16.
 */

public abstract class BaseListDataPresenter<T, V extends BaseView<T>> extends TiPresenter<V> {

    private RxTiPresenterSubscriptionHandler rxSubscriptionHelper = new RxTiPresenterSubscriptionHandler(this);
    private Observable<List<T>> listObservable;


    @Override
    protected void onCreate() {
        super.onCreate();
        listObservable = provideObservable();
    }


    public abstract Observable<List<T>> provideObservable();


    public void downloadData() {
        getView().showProgress(true);
        getView().hideErrorView();
        rxSubscriptionHelper.manageSubscription(listObservable.subscribe(new Observer<List<T>>() {
            @Override
            public void onCompleted() {
                getView().showProgress(false);
                getView().hideErrorView();
            }

            @Override
            public void onError(Throwable e) {
                Log.e("Error", e.getMessage());
                getView().showProgress(false);
                getView().showErrorView(e.getMessage());
            }

            @Override
            public void onNext(List<T> data) {
                getView().showData(data);
            }
        }));
    }

    @Override
    protected void onWakeUp() {
        super.onWakeUp();
        downloadData();
    }
}
