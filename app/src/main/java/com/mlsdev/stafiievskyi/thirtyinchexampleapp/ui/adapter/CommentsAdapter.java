package com.mlsdev.stafiievskyi.thirtyinchexampleapp.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mlsdev.stafiievskyi.thirtyinchexampleapp.R;
import com.mlsdev.stafiievskyi.thirtyinchexampleapp.model.dto.Comment;

import org.lucasr.twowayview.widget.SpannableGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oleksandr on 04.10.16.
 */

public class CommentsAdapter extends BaseAdapter<Comment, CommentsAdapter.CommentViewHolder> {
    @NonNull
    @Override
    public List<Comment> provideListType() {
        return new ArrayList<>();
    }


    @Override
    public CommentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comment, parent, false);
        return new CommentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CommentViewHolder holder, int position) {
        Log.e("SIze",String.valueOf(data.size()));
        final SpannableGridLayoutManager.LayoutParams lp =
                (SpannableGridLayoutManager.LayoutParams) holder.itemView.getLayoutParams();

        final int rowSpan = (position == 0 ? 2 : 1);
        final int colSpan = (position == 0 ? 2 : 1);

        if (lp.rowSpan != rowSpan || lp.colSpan != colSpan) {
            lp.rowSpan = rowSpan;
            lp.colSpan = colSpan;
            holder.itemView.setLayoutParams(lp);
        }
        holder.tvComment.setText(data.get(position).getBody());
    }

    public static class CommentViewHolder extends RecyclerView.ViewHolder {

        TextView tvComment;

        CommentViewHolder(View itemView) {
            super(itemView);
            tvComment = (TextView) itemView.findViewById(R.id.tvComment);
        }
    }
}
