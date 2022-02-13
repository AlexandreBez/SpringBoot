package com.hruser;

import com.hruser.entitys.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class userResources {
    
    @Autowired
    private UserRepository repository;
    
    @GetMapping("/{id}")
    public ResponseEntity<Users> findById( @PathVariable Long id ) {
        Users obj = repository.findById(id).get();
        return ResponseEntity.ok(obj);
    }

    @GetMapping("/search")
    public ResponseEntity<Users> findByeEmail( @RequestParam String email ) {
        Users obj = repository.findByEmail(email);
        return ResponseEntity.ok(obj);
    }
}