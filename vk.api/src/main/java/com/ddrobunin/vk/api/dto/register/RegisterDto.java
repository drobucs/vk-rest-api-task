package com.ddrobunin.vk.api.dto.register;

import com.ddrobunin.vk.api.model.Role;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;


public record RegisterDto(String username,
                          String password,
                          @JsonInclude(JsonInclude.Include.NON_NULL)
                          List<Role> roles) {
}
