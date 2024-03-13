package com.ddrobunin.vk.api.dto.users;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record TodoDto(Long userId, Long id, Long title, Boolean completed) {
}
