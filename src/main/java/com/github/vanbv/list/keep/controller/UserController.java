package com.github.vanbv.list.keep.controller;

import com.github.vanbv.list.keep.model.User;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @GetMapping("/current")
    public User getCurrentUser(KeycloakPrincipal<KeycloakSecurityContext> principal) {
        return new User(principal.getKeycloakSecurityContext().getToken().getPreferredUsername());
    }
}
