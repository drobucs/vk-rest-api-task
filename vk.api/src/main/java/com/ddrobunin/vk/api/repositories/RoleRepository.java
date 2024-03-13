package com.ddrobunin.vk.api.repositories;

import com.ddrobunin.vk.api.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findRoleByName(String username);
}
