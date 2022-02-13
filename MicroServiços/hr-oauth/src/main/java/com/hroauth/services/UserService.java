package com.hroauth.services;

import com.hroauth.entityes.Users;
import com.hroauth.feingclients.UserFeingClients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService{
    
    @Autowired
    private UserFeingClients userFeingClients;

    public Users findByEmail(String email){

        Users user = userFeingClients.findByEmail(email);
        if (user == null) {
            throw new IllegalArgumentException("Email not found"); 
        }

        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user = userFeingClients.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("Username not found"); 
        }

        return user;
    }
}