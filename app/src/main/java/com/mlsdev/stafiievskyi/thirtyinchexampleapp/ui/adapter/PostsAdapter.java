package com.mlsdev.stafiievskyi.thirtyinchexampleapp.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mlsdev.stafiievskyi.thirtyinchexampleapp.R;
import com.mlsdev.stafiievskyi.thirtyinchexampleapp.model.dto.Post;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oleksandr on 03.10.16.
 */

public class PostsAdapter extends BaseAdapter<Post, PostsAdapter.PostViewHolder> {


    @NonNull
    @Override
    public List<Post> provideListType() {
        return new ArrayList<>();
    }

    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post, parent, false);

        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PostViewHolder holder, int position) {
        final Post post = data.get(position);
        holder.body.setText(post.getBody());
        holder.title.setText(post.getTitle());
    }

   public static class PostViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView body;

        PostViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.tvTitle);
            body = (TextView) itemView.findViewById(R.id.tvBody);
        }
    }
}
