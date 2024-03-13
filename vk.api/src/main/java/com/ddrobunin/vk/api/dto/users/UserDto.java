package com.ddrobunin.vk.api.dto.users;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record UserDto(
        Long id,
        String name,
        String username,
        String email,
        AddressDto address,
        String phone,
        String website,
        CompanyDto company) {
}
