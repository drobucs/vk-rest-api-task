package com.ddrobunin.vk.api.dto.albums;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record PhotoDto(Long albumId, Long id, String title, String url, String thumbnailUrl) {
}
