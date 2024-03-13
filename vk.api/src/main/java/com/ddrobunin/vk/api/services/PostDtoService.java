package com.ddrobunin.vk.api.services;

import com.ddrobunin.vk.api.dto.posts.CommentDto;
import com.ddrobunin.vk.api.dto.posts.PostDto;
import com.ddrobunin.vk.api.web.JsonPlaceholderPostsApi;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostDtoService extends BaseDtoService {
    private final JsonPlaceholderPostsApi jsonPlaceholderPostsApi;


    @Cacheable(cacheNames = "posts")
    public List<PostDto> getPosts() {
        return execute(jsonPlaceholderPostsApi::getPosts);
    }

    @Cacheable(cacheNames = "post", key = "#postId")
    public PostDto getPost(long postId) {
        return execute(() -> jsonPlaceholderPostsApi.getPost(postId));
    }

    @Cacheable(cacheNames = "comments", key = "#postId")
    public List<CommentDto> getComments(long postId) {
        return execute(() -> jsonPlaceholderPostsApi.getComments(postId));
    }

    @CachePut(cacheNames = {"posts"})
    public PostDto createPost(PostDto post) {
        return execute(() -> jsonPlaceholderPostsApi.createPost(post));
    }


    @Caching(
            put = @CachePut(value = "post", key = "#postId"),
            evict = @CacheEvict("posts")
    )
    public PostDto updatePost(long postId, PostDto post) {
        return execute(() -> jsonPlaceholderPostsApi.updatePost(postId, post));
    }

    @Caching(
            evict = {
                    @CacheEvict("posts"),
                    @CacheEvict(value = "post", key = "#postId"),
            }
    )
    public PostDto deletePost(long postId) {
        return execute(() -> jsonPlaceholderPostsApi.deletePost(postId));
    }
}
