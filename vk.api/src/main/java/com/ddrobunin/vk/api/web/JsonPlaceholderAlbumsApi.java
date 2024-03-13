package com.ddrobunin.vk.api.web;


import com.ddrobunin.vk.api.dto.albums.AlbumDto;
import com.ddrobunin.vk.api.dto.albums.PhotoDto;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface JsonPlaceholderAlbumsApi {
    @GET("/albums")
    Call<List<AlbumDto>> getAlbums();

    @GET("/albums/{albumId}")
    Call<AlbumDto> getAlbum(@Path("albumId") long albumId);

    @GET("/albums/{albumId}/photos")
    Call<List<PhotoDto>> getPhotos(@Path("albumId") long albumId);

    @POST("/albums")
    Call<AlbumDto> createAlbum(@Body AlbumDto album);

    @PUT("/albums/{albumId}")
    Call<AlbumDto> updateAlbum(@Path("albumId") long albumId, @Body AlbumDto album);

    @DELETE("/albums/{albumId}")
    Call<AlbumDto> deleteAlbum(@Path("albumId") long albumId);
}
