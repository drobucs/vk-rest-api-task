package com.ddrobunin.vk.api.web;


import com.ddrobunin.vk.api.dto.posts.CommentDto;
import com.ddrobunin.vk.api.dto.posts.PostDto;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface JsonPlaceholderPostsApi {
    @GET("/posts")
    Call<List<PostDto>> getPosts();

    @GET("/posts/{postId}")
    Call<PostDto> getPost(@Path("postId") long postId);

    @GET("/posts/{postId}/comments")
    Call<List<CommentDto>> getComments(@Path("postId") long postId);

    @POST("/posts")
    Call<PostDto> createPost(@Body PostDto post);

    @PUT("/posts/{postId}")
    Call<PostDto> updatePost(@Path("postId") long postId, @Body PostDto post);

    @DELETE("/posts/{postId}")
    Call<PostDto> deletePost(@Path("postId") long postId);
}
