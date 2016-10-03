package com.mlsdev.stafiievskyi.thirtyinchexampleapp.model.api;


import com.mlsdev.stafiievskyi.thirtyinchexampleapp.model.dto.Comment;
import com.mlsdev.stafiievskyi.thirtyinchexampleapp.model.dto.Post;
import com.mlsdev.stafiievskyi.thirtyinchexampleapp.model.dto.User;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by oleksandr on 23.09.16.
 */

public interface FakeApiService {

    @GET("posts")
    Observable<List<Post>> getAllPosts();

    @GET("users")
    Observable<List<User>> getAllUsers();

    @GET("posts")
    Observable<List<Post>> getPostsByUserId(@Query("userId") String postId);

    @GET("comments")
    Observable<List<Comment>> getCommentByPostId(@Query("postId") String postId);

    @GET("comments")
    Observable<List<Comment>> getAllComment();
}
