package com.ddrobunin.vk.api.controllers;

import com.ddrobunin.vk.api.dto.register.RegisterDto;
import com.ddrobunin.vk.api.exceptions.Error;
import com.ddrobunin.vk.api.exceptions.SuchUserAlreadyExistException;
import com.ddrobunin.vk.api.model.Role;
import com.ddrobunin.vk.api.model.User;
import com.ddrobunin.vk.api.services.RoleService;
import com.ddrobunin.vk.api.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;
    private final RoleService roleService;

    @PostMapping("/register")
    private User register(@RequestBody RegisterDto register) {
        return userService.registerUser(register);
    }

    @GetMapping("/users")
    private List<User> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/roles")
    private List<Role> getRoles() {
        return roleService.getAllRoles();
    }

    @ExceptionHandler({SuchUserAlreadyExistException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private Error exceptionHandler(SuchUserAlreadyExistException e) {
        return new Error(e.getMessage());
    }
}
