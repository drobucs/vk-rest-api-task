package com.ddrobunin.vk.api.services;

import com.ddrobunin.vk.api.exceptions.NoSuchRoleException;
import com.ddrobunin.vk.api.model.Role;
import com.ddrobunin.vk.api.repositories.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public Role getRole(com.ddrobunin.vk.api.security.Role role) {
        return roleRepository.findRoleByName("ROLE_" + role.name()).orElseThrow(
                () -> new NoSuchRoleException("No such role exception: '" + role.name() + "'")
        );
    }

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
}
