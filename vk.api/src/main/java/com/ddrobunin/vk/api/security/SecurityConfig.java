package com.ddrobunin.vk.api.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final RolesProvider rolesProvider;

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        return http
                .httpBasic(Customizer.withDefaults())
                .authorizeHttpRequests(a -> a
                        .requestMatchers("/api/auth/**").anonymous()
                        .requestMatchers(HttpMethod.GET, "/api/posts/**").hasAnyRole(rolesProvider.postsGet())
                        .requestMatchers(HttpMethod.GET, "/api/users/**").hasAnyRole(rolesProvider.usersGet())
                        .requestMatchers(HttpMethod.GET, "/api/albums/**").hasAnyRole(rolesProvider.albumsGet())
                        .requestMatchers(HttpMethod.POST, "/api/posts/**").hasAnyRole(rolesProvider.postsPost())
                        .requestMatchers(HttpMethod.POST, "/api/users/**").hasAnyRole(rolesProvider.usersPost())
                        .requestMatchers(HttpMethod.POST, "/api/albums/**").hasAnyRole(rolesProvider.albumsPost())
                        .requestMatchers(HttpMethod.PUT, "/api/posts/**").hasAnyRole(rolesProvider.postsPut())
                        .requestMatchers(HttpMethod.PUT, "/api/users/**").hasAnyRole(rolesProvider.usersPut())
                        .requestMatchers(HttpMethod.PUT, "/api/albums/**").hasAnyRole(rolesProvider.albumsPut())
                        .requestMatchers(HttpMethod.DELETE, "/api/posts/**").hasAnyRole(rolesProvider.postsDelete())
                        .requestMatchers(HttpMethod.DELETE, "/api/users/**").hasAnyRole(rolesProvider.usersDelete())
                        .requestMatchers(HttpMethod.DELETE, "/api/albums/**").hasAnyRole(rolesProvider.albumsDelete())
                        .requestMatchers("/api/**").hasAnyRole(rolesProvider.allApi()))
                .csrf(AbstractHttpConfigurer::disable)
                .build();
    }


    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
