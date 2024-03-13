package com.ddrobunin.vk.api.dto.users;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record GeoDto(String lat, String lng) {
}
