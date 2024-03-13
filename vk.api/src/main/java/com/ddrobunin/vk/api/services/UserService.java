package com.ddrobunin.vk.api.services;

import com.ddrobunin.vk.api.dto.register.RegisterDto;
import com.ddrobunin.vk.api.exceptions.SuchUserAlreadyExistException;
import com.ddrobunin.vk.api.model.User;
import com.ddrobunin.vk.api.repositories.UserRepository;
import com.ddrobunin.vk.api.security.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    public User registerUser(RegisterDto register) {
        if (userExists(register.username())) {
            throw new SuchUserAlreadyExistException("User with such username already exist.");
        }
        var builder = User.builder()
                .username(register.username())
                .password(passwordEncoder.encode(register.password()));
        if (register.roles() == null)
            setDefaultRole(builder);
        else
            builder.roles(register.roles());
        return userRepository.save(builder.build());
    }

    private void setDefaultRole(User.UserBuilder builder) {
        builder.roles(List.of(
                roleService.getRole(Role.ADMIN)
        ));
    }

    public boolean userExists(String username) {
        return userRepository.existsByUsername(username);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
