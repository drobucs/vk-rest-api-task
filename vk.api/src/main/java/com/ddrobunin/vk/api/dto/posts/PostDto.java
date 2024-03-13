package com.ddrobunin.vk.api.dto.posts;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record PostDto(Long userId, Long id, String title, String body) {
}
