package com.ddrobunin.vk.api.controllers;

import com.ddrobunin.vk.api.dto.albums.AlbumDto;
import com.ddrobunin.vk.api.dto.posts.PostDto;
import com.ddrobunin.vk.api.dto.users.TodoDto;
import com.ddrobunin.vk.api.dto.users.UserDto;
import com.ddrobunin.vk.api.services.UserDtoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UsersController {
    private final UserDtoService userService;

    @GetMapping
    private List<UserDto> getPosts() {
        return userService.getUsers();
    }

    @GetMapping("/{userId}")
    private UserDto getPost(@PathVariable("userId") long userId) {
        return userService.getUser(userId);
    }

    @GetMapping("/{userId}/posts")
    private List<PostDto> getPosts(@PathVariable("userId") long userId) {
        return userService.getPosts(userId);
    }

    @GetMapping("/{userId}/todos")
    private List<TodoDto> getTodos(@PathVariable("userId") long userId) {
        return userService.getTodos(userId);
    }

    @GetMapping("/{userId}/albums")
    private List<AlbumDto> getAlbums(@PathVariable("userId") long userId) {
        return userService.getAlbums(userId);
    }

    @PostMapping
    private UserDto createPost(@RequestBody UserDto post) {
        return userService.createUser(post);
    }

    @PutMapping("/{userId}")
    private UserDto updatePost(@PathVariable("userId") long userId, @RequestBody UserDto user) {
        return userService.updateUser(userId, user);
    }

    @DeleteMapping("/{userId}")
    private UserDto deletePost(@PathVariable("userId") long userId) {
        return userService.deleteUser(userId);
    }
}
