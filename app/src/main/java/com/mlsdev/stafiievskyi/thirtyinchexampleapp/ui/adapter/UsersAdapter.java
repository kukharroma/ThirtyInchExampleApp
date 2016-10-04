package com.mlsdev.stafiievskyi.thirtyinchexampleapp.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mlsdev.stafiievskyi.thirtyinchexampleapp.R;
import com.mlsdev.stafiievskyi.thirtyinchexampleapp.model.dto.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oleksandr on 03.10.16.
 */

public class UsersAdapter extends BaseAdapter<User, UsersAdapter.UserViewHolder> {

    public UsersAdapter(OnAdapterItemClickListener<User> listener) {
        this.listener = listener;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        final User item = data.get(position);
        holder.name.setText(item.getName());
        holder.userName.setText(item.getUsername());
        holder.company.setText(item.getCompany().getName());
        holder.email.setText(item.getEmail());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(item);
            }
        });
    }


    @NonNull
    @Override
    public List<User> provideListType() {
        return new ArrayList<>();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView userName;
        TextView company;
        TextView email;

        UserViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.tvName);
            userName = (TextView) itemView.findViewById(R.id.tvUserName);
            company = (TextView) itemView.findViewById(R.id.tvCompany);
            email = (TextView) itemView.findViewById(R.id.tvEmail);
        }
    }
}
