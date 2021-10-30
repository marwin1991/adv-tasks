package com.codecool.marwin1991.controller;

import com.codecool.marwin1991.exception.ResourceNotFoundException;
import com.codecool.marwin1991.model.AppUser;
import com.codecool.marwin1991.repository.UserRepository;
import com.codecool.marwin1991.secuirty.CurrentUser;
import com.codecool.marwin1991.secuirty.UserPrincipal;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/profile")
    @PreAuthorize("hasRole('USER')")
    public AppUser getCurrentUser(@CurrentUser UserPrincipal userPrincipal){
        return userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }
}
