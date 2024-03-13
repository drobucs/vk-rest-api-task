package com.ddrobunin.vk.api.dto.posts;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record CommentDto(Long postId, Long id, String name, String email, String body) {
}
