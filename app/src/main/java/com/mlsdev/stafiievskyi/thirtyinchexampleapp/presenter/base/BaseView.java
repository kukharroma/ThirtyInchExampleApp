package com.mlsdev.stafiievskyi.thirtyinchexampleapp.presenter.base;

import net.grandcentrix.thirtyinch.TiView;
import net.grandcentrix.thirtyinch.distinctuntilchanged.DistinctUntilChanged;

import java.util.List;

/**
 * Created by oleksandr on 03.10.16.
 */

public interface BaseView<T> extends TiView {
    @DistinctUntilChanged
    void showData(List<T> data);

    void showProgress(boolean isShow);

    void showErrorView(String errorMessage);

    void hideErrorView();
}
