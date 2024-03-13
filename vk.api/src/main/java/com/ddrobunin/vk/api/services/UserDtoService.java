package com.ddrobunin.vk.api.services;

import com.ddrobunin.vk.api.dto.albums.AlbumDto;
import com.ddrobunin.vk.api.dto.posts.PostDto;
import com.ddrobunin.vk.api.dto.users.TodoDto;
import com.ddrobunin.vk.api.dto.users.UserDto;
import com.ddrobunin.vk.api.web.JsonPlaceholderUsersApi;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDtoService extends BaseDtoService {
    private final JsonPlaceholderUsersApi jsonPlaceholderUsersApi;


    @Cacheable("users")
    public List<UserDto> getUsers() {
        return execute(jsonPlaceholderUsersApi::getUsers);
    }

    @Cacheable(value = "user", key = "#userId")
    public UserDto getUser(long userId) {
        return execute(() -> jsonPlaceholderUsersApi.getUser(userId));
    }

    @Cacheable(value = "posts", key = "#userId")
    public List<PostDto> getPosts(long userId) {
        return execute(() -> jsonPlaceholderUsersApi.getPosts(userId));
    }

    @Cacheable(value = "todos", key = "#userId")
    public List<TodoDto> getTodos(long userId) {
        return execute(() -> jsonPlaceholderUsersApi.getTodos(userId));
    }

    @Cacheable(value = "albums", key = "#userId")
    public List<AlbumDto> getAlbums(long userId) {
        return execute(() -> jsonPlaceholderUsersApi.getAlbums(userId));
    }

    @Caching(
            put = @CachePut(value = "user", key = "#user.id()"),
            evict = @CacheEvict("users")
    )
    public UserDto createUser(UserDto user) {
        return execute(() -> jsonPlaceholderUsersApi.createUser(user));
    }

    @Caching(
            put = @CachePut(value = "user", key = "#user.id()"),
            evict = @CacheEvict("users")
    )
    public UserDto updateUser(long userId, UserDto user) {
        return execute(() -> jsonPlaceholderUsersApi.updateUser(userId, user));
    }

    @Caching(
            evict = {
                    @CacheEvict("users"),
                    @CacheEvict(value = "user", key = "#userId"),
            }
    )
    public UserDto deleteUser(long userId) {
        return execute(() -> jsonPlaceholderUsersApi.deleteUser(userId));
    }
}
