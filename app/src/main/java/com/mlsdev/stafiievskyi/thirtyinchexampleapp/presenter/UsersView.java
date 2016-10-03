package com.mlsdev.stafiievskyi.thirtyinchexampleapp.presenter;

import com.mlsdev.stafiievskyi.thirtyinchexampleapp.model.dto.User;

import net.grandcentrix.thirtyinch.TiView;
import net.grandcentrix.thirtyinch.callonmainthread.CallOnMainThread;
import net.grandcentrix.thirtyinch.distinctuntilchanged.DistinctUntilChanged;

import java.util.List;

/**
 * Created by oleksandr on 03.10.16.
 */

public interface UsersView extends TiView {

    @DistinctUntilChanged
    @CallOnMainThread
    void showUsers(List<User> users);

    @CallOnMainThread
    void showProgress(boolean isShow);

    @CallOnMainThread
    void showError(String errorMessage);

    @CallOnMainThread
    void hideErrorView();
}
