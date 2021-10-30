package com.codecool.marwin1991.service;

import com.codecool.marwin1991.exception.ResourceNotFoundException;
import com.codecool.marwin1991.model.AppUser;
import com.codecool.marwin1991.repository.UserRepository;
import com.codecool.marwin1991.secuirty.UserPrincipal;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException { //TODO change loadUserByUsername? loadUserByEmail
        AppUser appUser = repository.findByEmail(email)
                .orElseThrow(()-> new UsernameNotFoundException("User not found with email:" + email));

        return UserPrincipal.create(appUser);
    }

    @Override
    public UserDetails loadUserById(String id) {
        AppUser appUser = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User","id", id));

        return UserPrincipal.create(appUser);
    }
}
