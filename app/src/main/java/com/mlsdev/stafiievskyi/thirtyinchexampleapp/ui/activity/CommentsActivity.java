package com.mlsdev.stafiievskyi.thirtyinchexampleapp.ui.activity;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import com.mlsdev.stafiievskyi.thirtyinchexampleapp.R;
import com.mlsdev.stafiievskyi.thirtyinchexampleapp.model.dto.Comment;
import com.mlsdev.stafiievskyi.thirtyinchexampleapp.model.dto.Post;
import com.mlsdev.stafiievskyi.thirtyinchexampleapp.presenter.impl.CommentsListDataPresenter;
import com.mlsdev.stafiievskyi.thirtyinchexampleapp.presenter.view.CommentsView;
import com.mlsdev.stafiievskyi.thirtyinchexampleapp.ui.adapter.BaseAdapter;
import com.mlsdev.stafiievskyi.thirtyinchexampleapp.ui.adapter.CommentsAdapter;

import org.lucasr.twowayview.TwoWayLayoutManager;
import org.lucasr.twowayview.widget.SpannableGridLayoutManager;

/**
 * Created by oleksandr on 04.10.16.
 */

public class CommentsActivity extends BaseListDataActivity<CommentsListDataPresenter, Comment, CommentsView, CommentsAdapter.CommentViewHolder> {
    public static final String POST_ID_EXTRA = "post_id_extra";

    @Override
    protected int getLayoutID() {
        return R.layout.activity_comments;
    }

    @Override
    protected BaseAdapter<Comment, CommentsAdapter.CommentViewHolder> provideAdapter() {
        return new CommentsAdapter();
    }

    @Override
    protected RecyclerView.LayoutManager provideLayoutManager() {
        return new SpannableGridLayoutManager(TwoWayLayoutManager.Orientation.VERTICAL, 3, 1);
    }

    @Override
    public void onItemClick(Comment item) {

    }

    @NonNull
    @Override
    public CommentsListDataPresenter providePresenter() {
        Post post = (Post) getIntent().getSerializableExtra(POST_ID_EXTRA);
        return new CommentsListDataPresenter(String.valueOf(post.getId()));
    }
}
