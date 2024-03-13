package com.ddrobunin.vk.api.dto.users;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record CompanyDto(String name, String catchPhrase, String bs) {
}
