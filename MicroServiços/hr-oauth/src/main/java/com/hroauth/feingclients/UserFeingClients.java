package com.hroauth.feingclients;

import com.hroauth.entityes.Users;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "hr-user", path = "/users")
public interface UserFeingClients {
    
    @GetMapping("/search")
    public Users findByEmail(@RequestParam String email);
}