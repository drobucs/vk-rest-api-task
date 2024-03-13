package com.ddrobunin.vk.api.security;


import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.ddrobunin.vk.api.security.Role.*;

@Component
public class RolesProvider {

    private List<Role> merge(List<Role> roles, Role... toAddRoles) {
        Collections.addAll(roles, toAddRoles);
        return roles;
    }

    private List<Role> allRights() {
        return merge(new ArrayList<>(), ADMIN);
    }

    private List<Role> posts() {
        return merge(allRights(), POSTS);
    }

    private List<Role> users() {
        return merge(allRights(), USERS);
    }

    private List<Role> albums() {
        return merge(allRights(), ALBUMS);
    }

    private List<Role> postsViewers() {
        return merge(posts(), POSTS_VIEWER);
    }

    private List<Role> postsCreators() {
        return merge(posts(), POSTS_CREATOR);
    }

    private List<Role> postsUpdaters() {
        return merge(posts(), POSTS_UPDATER);
    }

    private List<Role> postsDeletes() {
        return merge(posts(), POSTS_DELETER);
    }

    private List<Role> usersViewers() {
        return merge(users(), USERS_VIEWER);
    }

    private List<Role> usersCreators() {
        return merge(users(), USERS_CREATOR);
    }

    private List<Role> usersUpdater() {
        return merge(users(), USERS_UPDATER);
    }

    private List<Role> usersDeletes() {
        return merge(users(), USERS_DELETER);
    }

    private List<Role> albumsViewers() {
        return merge(albums(), ALBUMS_VIEWER);
    }

    private List<Role> albumsCreators() {
        return merge(albums(), ALBUMS_CREATOR);
    }

    private List<Role> albumsUpdaters() {
        return merge(albums(), ALBUMS_UPDATER);
    }

    private List<Role> albumsDeletes() {
        return merge(albums(), ALBUMS_DELETER);
    }

    private String[] toStringArray(List<Role> roles) {
        return roles.stream().map(Enum::name).toArray(String[]::new);
    }

    public String[] postsGet() {
        return toStringArray(postsViewers());
    }

    public String[] postsPost() {
        return toStringArray(postsCreators());
    }

    public String[] postsPut() {
        return toStringArray(postsUpdaters());
    }

    public String[] postsDelete() {
        return toStringArray(postsDeletes());
    }


    public String[] usersGet() {
        return toStringArray(usersViewers());
    }

    public String[] usersPost() {
        return toStringArray(usersCreators());
    }

    public String[] usersPut() {
        return toStringArray(usersUpdater());
    }

    public String[] usersDelete() {
        return toStringArray(usersDeletes());
    }

    public String[] albumsGet() {
        return toStringArray(albumsViewers());
    }

    public String[] albumsPost() {
        return toStringArray(albumsCreators());
    }

    public String[] albumsPut() {
        return toStringArray(albumsUpdaters());
    }

    public String[] albumsDelete() {
        return toStringArray(albumsDeletes());
    }

    public String[] allApi() {
        return toStringArray(allRights());
    }
}
