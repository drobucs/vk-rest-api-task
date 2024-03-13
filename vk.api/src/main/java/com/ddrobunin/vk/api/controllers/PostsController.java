package com.ddrobunin.vk.api.controllers;

import com.ddrobunin.vk.api.dto.posts.CommentDto;
import com.ddrobunin.vk.api.dto.posts.PostDto;
import com.ddrobunin.vk.api.services.PostDtoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostsController {
    private final PostDtoService postService;

    @GetMapping
    private List<PostDto> getPosts() {
        return postService.getPosts();
    }

    @GetMapping("/{postId}")
    private PostDto getPost(@PathVariable("postId") long postId) {
        return postService.getPost(postId);
    }

    @GetMapping("/{postId}/comments")
    private List<CommentDto> getPosts(@PathVariable("postId") long postId) {
        return postService.getComments(postId);
    }

    @PostMapping
    private PostDto createPost(@RequestBody PostDto post) {
        return postService.createPost(post);
    }

    @PutMapping("/{postId}")
    private PostDto updatePost(@PathVariable("postId") long postId, @RequestBody PostDto post) {
        return postService.updatePost(postId, post);
    }

    @DeleteMapping("/{postId}")
    private PostDto deletePost(@PathVariable("postId") long postId) {
        return postService.deletePost(postId);
    }
}
