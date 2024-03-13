package com.ddrobunin.vk.api.services;

import com.ddrobunin.vk.api.dto.albums.AlbumDto;
import com.ddrobunin.vk.api.dto.albums.PhotoDto;
import com.ddrobunin.vk.api.web.JsonPlaceholderAlbumsApi;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlbumDtoService extends BaseDtoService {
    private final JsonPlaceholderAlbumsApi jsonPlaceholderAlbumsApi;

    @Cacheable("albums")
    public List<AlbumDto> getAlbums() {
        return execute(jsonPlaceholderAlbumsApi::getAlbums);
    }

    @Cacheable(value = "album", key = "#albumId")
    public AlbumDto getAlbum(long albumId) {
        return execute(() -> jsonPlaceholderAlbumsApi.getAlbum(albumId));
    }

    @Cacheable(value = "photos", key = "#albumId")
    public List<PhotoDto> getPhotos(long albumId) {
        return execute(() -> jsonPlaceholderAlbumsApi.getPhotos(albumId));
    }

    @Caching(
            put = @CachePut(value = "album", key = "#album.id()"),
            evict = @CacheEvict("albums")
    )
    public AlbumDto createAlbum(AlbumDto album) {
        return execute(() -> jsonPlaceholderAlbumsApi.createAlbum(album));
    }

    @Caching(
            put = @CachePut(value = "album", key = "#albumId"),
            evict = @CacheEvict("albums")
    )
    public AlbumDto updateAlbum(long albumId, AlbumDto album) {
        return execute(() -> jsonPlaceholderAlbumsApi.updateAlbum(albumId, album));
    }

    @Caching(
            evict = {
                    @CacheEvict("albums"),
                    @CacheEvict(value = "album", key = "#albumId")
            }
    )
    public AlbumDto deleteAlbum(long albumId) {
        return execute(() -> jsonPlaceholderAlbumsApi.deleteAlbum(albumId));
    }
}
