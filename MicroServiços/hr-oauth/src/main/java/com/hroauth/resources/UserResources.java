package com.hroauth.resources;

import com.hroauth.entityes.Users;
import com.hroauth.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserResources {
    
    @Autowired
    private UserService service;

    @GetMapping("/search")
    public ResponseEntity<Users> findByEmail(@RequestParam String email){

        try {
            Users user = service.findByEmail(email);
            return ResponseEntity.ok(user);
        }
        catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}