package com.mlsdev.stafiievskyi.thirtyinchexampleapp.presenter.base;

import net.grandcentrix.thirtyinch.TiView;
import net.grandcentrix.thirtyinch.callonmainthread.CallOnMainThread;
import net.grandcentrix.thirtyinch.distinctuntilchanged.DistinctUntilChanged;

import java.util.List;

/**
 * Created by oleksandr on 03.10.16.
 */

public interface BaseView<T> extends TiView {
    @DistinctUntilChanged
    @CallOnMainThread
    void showData(List<T> data);

    @CallOnMainThread
    void showProgress(boolean isShow);

    @CallOnMainThread
    void showErrorView(String errorMessage);

    @CallOnMainThread
    void hideErrorView();
}
