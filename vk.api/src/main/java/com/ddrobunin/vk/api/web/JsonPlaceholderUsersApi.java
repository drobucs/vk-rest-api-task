package com.ddrobunin.vk.api.web;


import com.ddrobunin.vk.api.dto.albums.AlbumDto;
import com.ddrobunin.vk.api.dto.posts.PostDto;
import com.ddrobunin.vk.api.dto.users.TodoDto;
import com.ddrobunin.vk.api.dto.users.UserDto;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface JsonPlaceholderUsersApi {
    @GET("/users")
    Call<List<UserDto>> getUsers();

    @GET("/users/{userId}")
    Call<UserDto> getUser(@Path("userId") long postId);

    @GET("/users/{userId}/posts")
    Call<List<PostDto>> getPosts(@Path("userId") long userId);

    @GET("/users/{userId}/todos")
    Call<List<TodoDto>> getTodos(@Path("userId") long userId);

    @GET("/users/{userId}/albums")
    Call<List<AlbumDto>> getAlbums(@Path("userId") long userId);

    @POST("/users")
    Call<UserDto> createUser(@Body UserDto post);

    @PUT("/users/{userId}")
    Call<UserDto> updateUser(@Path("userId") long userId, @Body UserDto post);

    @DELETE("/users/{userId}")
    Call<UserDto> deleteUser(@Path("userId") long userId);
}
