package com.ddrobunin.vk.api.dto.albums;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record AlbumDto(Long userId, Long id, String title) {
}
