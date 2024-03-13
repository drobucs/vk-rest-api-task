package com.ddrobunin.vk.api.controllers;

import com.ddrobunin.vk.api.dto.albums.AlbumDto;
import com.ddrobunin.vk.api.dto.albums.PhotoDto;
import com.ddrobunin.vk.api.services.AlbumDtoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/albums")
@RequiredArgsConstructor
public class AlbumsController {
    private final AlbumDtoService albumDtoService;

    @GetMapping
    private List<AlbumDto> getPosts() {
        return albumDtoService.getAlbums();
    }

    @GetMapping("/{albumId}")
    private AlbumDto getPost(@PathVariable("albumId") long albumId) {
        return albumDtoService.getAlbum(albumId);
    }

    @GetMapping("/{albumId}/photos")
    private List<PhotoDto> getPosts(@PathVariable("albumId") long albumId) {
        return albumDtoService.getPhotos(albumId);
    }

    @PostMapping
    private AlbumDto createAlbum(@RequestBody AlbumDto album) {
        return albumDtoService.createAlbum(album);
    }

    @PutMapping("/{albumId}")
    private AlbumDto updateAlbum(@PathVariable("albumId") long albumId, @RequestBody AlbumDto album) {
        return albumDtoService.updateAlbum(albumId, album);
    }

    @DeleteMapping("/{postId}")
    private AlbumDto deleteAlbum(@PathVariable("postId") long postId) {
        return albumDtoService.deleteAlbum(postId);
    }
}
