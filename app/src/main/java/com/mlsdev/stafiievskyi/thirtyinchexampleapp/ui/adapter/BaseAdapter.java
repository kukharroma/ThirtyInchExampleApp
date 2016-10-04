package com.mlsdev.stafiievskyi.thirtyinchexampleapp.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import java.util.List;

/**
 * Created by oleksandr on 03.10.16.
 */

public abstract class BaseAdapter<T, H extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<H> {
    protected List<T> data;
    OnAdapterItemClickListener<T> listener;

    BaseAdapter() {
        data = provideListType();
    }

    @NonNull
    public abstract List<T> provideListType();

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List<T> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public void addData(List<T> data) {
        this.data.addAll(data);
        notifyDataSetChanged();
    }
}
